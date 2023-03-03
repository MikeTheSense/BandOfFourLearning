package learnpatterns.Command;

import learnpatterns.Models.Car;

import java.io.PrintWriter;

public class CarCommandColumnPrinter implements CarCommand {
    public CarCommandColumnPrinter() {
    }
    @Override
    public void print(PrintWriter printWriter, Car theCar) {
        String modelNames[] = theCar.getAllModelsName();
        double modelPrices[] =theCar.getAllModelsPrice();
        printWriter.println("Car brand: " + theCar.getBrand());
        for (int i = 0; i<theCar.getSize(); i++)
        {
            printWriter.println("Model brand: " + modelNames[i]+ " price is: "+modelPrices[i]);
        }
        printWriter.flush();
    }
}
