package learnpatterns;

import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Exceptions.NoSuchModelNameException;

public interface Vehicle {
    String getBrand();
    void setBrandName(String brandName);
    String[] getAllModelsName();
    void changeModelName(String srcModelName, String dstModelName) throws NoSuchModelNameException, DuplicateModelNameException;
    double getPriceByModelName(String modelName) throws NoSuchModelNameException;
    void setPriceByModelName(String modelName, int newPrice) throws NoSuchModelNameException;
    double[] getAllModelsPrice();
    void addNewModel(String modelName, double modelPrice) throws DuplicateModelNameException;
    void deleteSelectedModel(String modelName, double modelPrice) throws NoSuchModelNameException;
    int getSize();
    Vehicle clone() throws CloneNotSupportedException;
}
