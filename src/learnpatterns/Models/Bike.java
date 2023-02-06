package learnpatterns.Models;
import learnpatterns.*;
import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Exceptions.ModelPriceOutOfBoundsException;
import learnpatterns.Exceptions.NoModelsException;
import learnpatterns.Exceptions.NoSuchModelNameException;

import java.util.Date;


public class Bike implements Vehicle {
    private String brandName;
    private int size = 0;
    private long lastModified;
    private Model head = new Model();
    {
        head.next = head;
        head.prev = head;
    }
    {
        Date current = new Date();
        lastModified = current.getTime();
    }
    private final String defaultName =  "default";
    private final double defaultPrice = 1;

    public String getBrand() {
        return brandName;
    }

    public int getSize()
    {
        return size;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
        Date current = new Date();
        setLastModified(current.getTime());
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public Bike (String brandName, int size)
    {
        setBrandName(brandName);
        this.size = size;
        Model temporary = head;
        for (int i = 0; i < size ; i++)
        {
            temporary.next = new Model(defaultName + " " + i, defaultPrice + 1, head, temporary);
            head.prev = temporary.next;
            temporary = temporary.next;
        }
        Date current = new Date();
        setLastModified(current.getTime());
    }

    public void changeModelName(String srcName, String dstName) throws DuplicateModelNameException, NoSuchModelNameException
    {
        if (size > 0 ) {
            Model temporary = head, finded = null;
            while(temporary.next != head && !temporary.next.getName().equals(dstName))
            {
                if(temporary.next.getName().equals(srcName))
                    finded = temporary.next;
                temporary = temporary.next;
            }
            if (temporary.next.getName().equals(dstName))
            {
                throw new DuplicateModelNameException(dstName);
            }
            if (finded != null)
            {
                finded.setName(dstName);
                Date current = new Date();
                setLastModified(current.getTime());
            }
            else throw new NoSuchModelNameException(srcName);
        }
        else throw new NoModelsException();
    }

    public String[] getAllModelsName()
    {
        String arrayNames[] = new String[size];
        Model tmp = head;
        int i = 0;
        while(tmp.next!=head)
        {
            arrayNames[i] = tmp.next.getName();
            tmp = tmp.next;
            i++;
        }
        return arrayNames;
    }

    public double getPriceByModelName (String modelName) throws NoSuchModelNameException{
        if (size == 0) throw new NoModelsException();
        Model tmp = head;
        while (tmp.next != head && !tmp.next.getName().equals(modelName))
            tmp = tmp.next;
        if (tmp.next.getName().equals(modelName))
        {
            return tmp.next.getPrice();
        }
        else throw new NoSuchModelNameException(modelName);
    }

    public void setPriceByModelName(String modelName, int newPrice) throws NoSuchModelNameException{
        if (size == 0) throw new NoModelsException();
        Model tmp = head;
        while (tmp.next != head && !tmp.next.getName().equals(modelName))
            tmp = tmp.next;
        if (tmp.next.getName().equals(modelName))
        {
            tmp.next.setPrice(newPrice);
            Date current = new Date();
            setLastModified(current.getTime());
        }
        else throw new NoSuchModelNameException(modelName);
    }

    public double[] getAllModelsPrice()
    {
        if (size == 0) throw new NoModelsException();
        double arrayOfPrices[] = new double[size];
        Model tmp = head;
        int i = 0;
        while (tmp.next != head)
        {
            arrayOfPrices[i] = tmp.next.getPrice();
            i++;
            tmp = tmp.next;
        }
        return arrayOfPrices;
    }

    public void addNewModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        Model tmp = head;
        while (tmp.next != head && !tmp.next.getName().equals(modelName))
            tmp = tmp.next;
        if (tmp.next.getName().equals(modelName))
            throw new DuplicateModelNameException(modelName);
        Model newModel = new Model(modelName, modelPrice,head, head.prev);
        head.prev.next = newModel;
        head.prev = newModel;
        size++;
        Date current = new Date();
        setLastModified(current.getTime());
    }

    public void deleteSelectedModel(String modelName, double modelPrice) throws NoSuchModelNameException{
        if (size == 0) throw new NoModelsException();
        Model tmp = head;
        while (tmp.next != head && !tmp.next.getName().equals(modelName))
            tmp = tmp.next;
        if (tmp.next.getName().equals(modelName) && tmp.next.getPrice() == modelPrice)
        {
            tmp = tmp.next;
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
            size--;
            Date current = new Date();
            setLastModified(current.getTime());
        }
        else throw new NoSuchModelNameException(modelName);

    }


    private class Model{
        private String name;
        private double price = Double.NaN;
        Model prev = null;
        Model next = null;

        public void setName(String name) {
            this.name = name;
        }
        public String getName(){
            return name;
        }

        public void setPrice(double price) {
            if (price > 0)
                this.price = price;
            else throw new ModelPriceOutOfBoundsException();
        }

        public double getPrice()
        {
            return price;
        }

        public Model()
        {
            name = "";
            price = 0.0;
        }

        public Model(String name, double price)
        {
            setName(name);
            setPrice(price);
        }

        public Model(String name, double price, Model next, Model prev)
        {
            this(name,price);
            this.next = next;
            this.prev = prev;
        }

    }
}