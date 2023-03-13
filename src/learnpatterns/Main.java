package learnpatterns;
import learnpatterns.ChainOfResponsibility.ChainOfResponsibility;
import learnpatterns.ChainOfResponsibility.ColumnHandler;
import learnpatterns.ChainOfResponsibility.LineHandler;
import learnpatterns.Command.CarCommandColumnPrinter;
import learnpatterns.Command.CarCommandLinePrinter;
import learnpatterns.DAO.VehicleDAOFactory;
import learnpatterns.Models.Bike;
import learnpatterns.Models.Car;
import learnpatterns.Strategy.CalculationNumberOfOccurens;
import learnpatterns.Strategy.CalculationNumberOfOccurensAlgorithmImplementation;
import learnpatterns.Strategy.CalculationNumberOfOccurensMapImplementation;
import learnpatterns.Visitor.Visitor;
import learnpatterns.Visitor.VisitorImplementation;

import java.io.*;
import java.lang.management.MemoryNotificationInfo;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        VehicleOperations.setFactory(new CarFactory());
        Vehicle car = VehicleOperations.createInstance("MikeCar",5);

        VehicleOperations.setFactory(new BikeFactory());
        Vehicle bike = VehicleOperations.createInstance("MikeBike",5);


        VehicleDAOFactory.getVehicleDAO("src/Resources/source").writeObject(bike);
        Vehicle result = VehicleDAOFactory.getVehicleDAO("src/Resources/source").readObject(new Bike());

        VehicleDAOFactory.getVehicleDAO("src/Resources/source.txt").writeObject(car);
        Vehicle secondResult = VehicleDAOFactory.getVehicleDAO("src/Resources/source.txt").readObject(new Car());

        ChainOfResponsibility ch = new LineHandler(3);
        ch.setHandler(new ColumnHandler(3));

        ch.write(result);
        ch.write(secondResult);

        //
        //System.out.println(result.getBrand());
        //VehicleOperations.printModelsInfo(result);



    }
}
