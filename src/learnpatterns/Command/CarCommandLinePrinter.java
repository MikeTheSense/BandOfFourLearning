package learnpatterns.Command;

import learnpatterns.Models.Car;

import java.io.PrintWriter;

public class CarCommandLinePrinter implements CarCommand{
    public CarCommandLinePrinter() {
    }
    @Override
    public void print(PrintWriter printWriter,Car theCar) {
        String modelNames[] = theCar.getAllModelsName();
        double modelPrices[] =theCar.getAllModelsPrice();
        printWriter.print("Car brand: " + theCar.getBrand());
        for (int i = 0; i<theCar.getSize(); i++)
        {
            printWriter.print("Model brand: " + modelNames[i]+ " price is: "+modelPrices[i]);
        }
        printWriter.println();
        printWriter.flush();
    }
}
