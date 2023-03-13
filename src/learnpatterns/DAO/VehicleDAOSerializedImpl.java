package learnpatterns.DAO;

import learnpatterns.Vehicle;

import java.io.*;

public class VehicleDAOSerializedImpl implements VehicleDAO {
    private String sourceFileName;
    public VehicleDAOSerializedImpl(String source) {
        this.sourceFileName = source;
    }

    @Override
    public Vehicle readObject(Vehicle vehicle) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sourceFileName))) {
            vehicle = (Vehicle) ois.readObject();
            return vehicle;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Stream can't be opened");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't found a class");
        }
        return null;
    }

    @Override
    public void writeObject(Vehicle vehicle) {
        try (ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(sourceFileName))) {
            ois.writeObject(vehicle);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Stream can't be opened");
        }
    }
}
