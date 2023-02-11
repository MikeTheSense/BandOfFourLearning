package learnpatterns.Decorator;

import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Exceptions.NoSuchModelNameException;
import learnpatterns.Vehicle;
import learnpatterns.VehicleOperations;

public class syncronizedVehicleOperations implements Vehicle {
    private Vehicle vehicle;

    public syncronizedVehicleOperations(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public synchronized String getBrand() {
        return vehicle.getBrand();
    }

    @Override
    public synchronized void setBrandName(String brandName) {
        vehicle.setBrandName(brandName);
    }

    @Override
    public synchronized String[] getAllModelsName() {
        return vehicle.getAllModelsName();
    }

    @Override
    public synchronized void changeModelName(String srcModelName, String dstModelName) throws NoSuchModelNameException, DuplicateModelNameException {
        vehicle.changeModelName(srcModelName, dstModelName);
    }

    @Override
    public synchronized double getPriceByModelName(String modelName) throws NoSuchModelNameException {
        return vehicle.getPriceByModelName(modelName);
    }

    @Override
    public synchronized void setPriceByModelName(String modelName, int newPrice) throws NoSuchModelNameException {
        vehicle.setPriceByModelName(modelName, newPrice);
    }

    @Override
    public synchronized double[] getAllModelsPrice() {
        return vehicle.getAllModelsPrice();
    }

    @Override
    public synchronized void addNewModel(String modelName, double modelPrice) throws DuplicateModelNameException {
        vehicle.addNewModel(modelName, modelPrice);
    }

    @Override
    public synchronized void deleteSelectedModel(String modelName, double modelPrice) throws NoSuchModelNameException {
        vehicle.deleteSelectedModel(modelName, modelPrice);
    }

    @Override
    public synchronized int getSize() {
        return vehicle.getSize();
    }

    @Override
    public synchronized Vehicle clone() throws CloneNotSupportedException {
        return vehicle.clone();
    }
}
