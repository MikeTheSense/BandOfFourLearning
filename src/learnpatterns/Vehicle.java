package learnpatterns;

import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Exceptions.NoSuchModelNameException;

public interface Vehicle {
    String getBrand();
    void setBrandName(String brandName);
    public String[] getAllModelsName();
    public void changeModelName(String srcModelName, String dstModelName) throws NoSuchModelNameException, DuplicateModelNameException;
    public double getPriceByModelName(String modelName) throws NoSuchModelNameException;
    public void setPriceByModelName(String modelName, int newPrice) throws NoSuchModelNameException;
    public double[] getAllModelsPrice();
    public void addNewModel(String modelName, double modelPrice) throws DuplicateModelNameException;
    public void deleteSelectedModel(String modelName, double modelPrice) throws NoSuchModelNameException;
    public int getSize();
}
