package learnpatterns.Models;


import learnpatterns.Command.CarCommand;
import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Exceptions.ModelPriceOutOfBoundsException;
import learnpatterns.Exceptions.NoModelsException;
import learnpatterns.Exceptions.NoSuchModelNameException;
import learnpatterns.Vehicle;
import learnpatterns.Visitor.Visitor;

import java.io.*;
import java.util.Arrays;
import java.util.Iterator;

public class Car implements Vehicle, Cloneable,Serializable {
    private String brandName = "default";
    private Model[] models;
    private final String defaultName =  "default";
    private final double defaultPrice = 1;
    private CarCommand command;

    public void setCommand(CarCommand command) {
        this.command = command;
    }
    public CarCommand getCommand() {
        return this.command;
    }


    public Car(String brandName)
    {
        this.brandName = brandName;
    }
    public Car()
    {}
    public Car(String brandName, int modelsSize)
    {
        this.brandName = brandName;
        this.models = new Model[modelsSize];
        for (int i = 0; i < modelsSize ; i++)
            models[i] = new Model(defaultName + " " + (i + 1), defaultPrice+i);
    };

    public void setBrandName(String brandName){
        this.brandName=brandName;
    }

    public String getBrand(){
        return brandName;
    }

    public String[] getAllModelsName() {
        if (models == null) throw new NoModelsException();
        String modelsName[] = new String[models.length];
        for (int i = 0; i < models.length; i++) {
            modelsName[i] = models[i].getModelName();
        }
        return modelsName;
    }

    public void print(OutputStream ous){
        this.command.print(new PrintWriter(ous),this);
    }

    public void changeModelName(String srcModelName, String dstModelName) throws NoSuchModelNameException, DuplicateModelNameException
    {
        if (models == null) throw new NoModelsException();
        if (!srcModelName.equals(dstModelName))
        {
            int i = 0, posOfName = -1;
            while (i < models.length && !models[i].getModelName().equals(dstModelName))
            {
                if (models[i].getModelName().equals(srcModelName)) posOfName = i;
                i++;
            }
            if (i < models.length) throw new DuplicateModelNameException(dstModelName);
            if (posOfName == -1) throw new NoSuchModelNameException(srcModelName);
            models[posOfName].setModelName(dstModelName);
        }
    }
    public double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        if (models == null) throw new NoModelsException();
        int i = 0;
        while (i < models.length && !(models[i].getModelName().equals(modelName))) i++;
        if (i < models.length) return models[i].getModelPrice();
        throw new NoSuchModelNameException(modelName);
    }

    public void setPriceByModelName(String modelName, int newPrice) throws NoSuchModelNameException{
        if (models == null) throw new NoModelsException();
        int i = 0;
        while(i< models.length && !(models[i].getModelName().equals(modelName)))
            i++;
        if (i < models.length) models[i].setPrice(newPrice);
        else throw new NoSuchModelNameException(modelName);
    }

    public double[] getAllModelsPrice()
    {
        if (models == null) throw new NoModelsException();
        double modelsPrice[] = new double[models.length];
        for (int i = 0; i < models.length; i++ )
        {
            modelsPrice[i] = models[i].getModelPrice();
        }
        return modelsPrice;
    }

    public void addNewModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        if (models == null) {
            models = new Model[1];
            models[0] = new Model(modelName, modelPrice);
        }
        else {
            int i = 0;
            while (i < models.length && !(models[i].getModelName().equals(modelName))) i++;
            if (i != models.length) throw new DuplicateModelNameException(modelName);
            models = Arrays.copyOf(models, models.length + 1);
            models[models.length - 1] = new Model(modelName, modelPrice);
        }
    }

    public void deleteSelectedModel(String modelName, double modelPrice) throws NoSuchModelNameException
    {
        int i = 0;
        while (i < models.length && !models[i].getModelName().equals(modelName)) i++;
        if (i < models.length && models[i].getModelPrice()==modelPrice) {
            if(models.length == 1)
            {
                models = null;
            }
            else {
                if (i < models.length - 1) System.arraycopy(models, i + 1, models, i, models.length - i - 1);
                models = Arrays.copyOf(models, models.length - 1);
            }
        }
        else throw new NoSuchModelNameException(modelName);
    }

    public int getSize()
    {
        if (models == null) throw new NoModelsException();
        return models.length;
    }

    @Override
    public Car clone() throws CloneNotSupportedException{
        Car clonedCar = (Car)super.clone();
        clonedCar.models = new Model[getSize()];
        for (int i = 0; i < getSize(); i++ )
        {
            clonedCar.models[i] = models[i].clone();
        }
        return clonedCar;
    }
    public Iterator<Model> iterator() {
        return new CarIterator();
    }

    public Memento createMemento() throws IOException
    {
        Memento mem = new Memento();
        mem.createCar(this);
        return mem;
    }
    public Car setMemento(Memento memento) throws IOException, ClassNotFoundException
    {
        return memento.getCar();
    }

    public void accept(Visitor visitor){visitor.visit(this);}



    protected static class Model implements Cloneable,Serializable{
        String modelName;
        double price;

        public double getModelPrice() {
            return price;
        }

        public void setPrice(double price)
        {
            if (price > 0)
                this.price = price;
            else throw new ModelPriceOutOfBoundsException();
        }

        public String getModelName() {
            return modelName;
        }

        public void setModelName(String modelName)
        {
            this.modelName = modelName;
        }

        public Model(String modelName, double price)
        {
            setModelName(modelName);
            setPrice(price);
        }
        @Override
        public Model clone() throws CloneNotSupportedException{
            return (Model)super.clone();
        }
        @Override
        public String toString()
        {
            return this.modelName + " " + this.price;
        }
    }



    private class CarIterator implements Iterator<Model>{
        private int index;

        @Override
        public boolean hasNext() {
            return index < getSize();
        }

        @Override
        public Model next() {
            return models[index++];
        }
    }

    public static class Memento {
        private byte[] memento;
        public void createCar(Car car) throws IOException {
            ByteArrayOutputStream bys = new ByteArrayOutputStream();
            ObjectOutputStream ous = new ObjectOutputStream(bys);
            ous.writeObject(car);
            ous.flush();
            this.memento = bys.toByteArray();
        }

        public Car getCar() throws IOException,ClassNotFoundException{
            ByteArrayInputStream bis = new ByteArrayInputStream(memento);
            ObjectInputStream ois = new ObjectInputStream(bis);
            return (Car)ois.readObject();
        }









    }
}
