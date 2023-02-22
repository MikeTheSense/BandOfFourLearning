package learnpatterns.ChainOfResponsibility;

import com.sun.net.httpserver.Filter;
import learnpatterns.Vehicle;

import java.io.IOException;
import java.sql.SQLOutput;



public class LineHandler implements ChainOfResponsibility{
    private int size;
    private ChainOfResponsibility nextHandler;

    public LineHandler(int size) {
        this.size = size;
    }


    @Override
    public void write(Vehicle vehicle) {
        if (vehicle.getSize()<=this.size)
        {
            String [] modelNames = vehicle.getAllModelsName();
            double [] modelPrices = vehicle.getAllModelsPrice();
            System.out.print("Vehicle brand: " + vehicle.getBrand() + "; ");
            for (int i = 0; i< modelNames.length; i++)
            {
                System.out.printf("Model name: "+ modelNames[i]+ " price is: " + modelPrices[i]+"; ");
            }
            System.out.println("");
        }
        else this.nextHandler.write(vehicle);
    }

    @Override
    public void setHandler(ChainOfResponsibility handler) {
        this.nextHandler = handler;

    }

}
