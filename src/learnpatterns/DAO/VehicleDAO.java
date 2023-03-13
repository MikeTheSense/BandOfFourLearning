package learnpatterns.DAO;

import learnpatterns.Vehicle;

import java.io.FileNotFoundException;

public interface VehicleDAO {
    Vehicle readObject(Vehicle vehicle);
    void writeObject(Vehicle vehicle);
}
