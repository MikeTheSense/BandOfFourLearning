package learnpatterns.ChainOfResponsibility;

import learnpatterns.Vehicle;

import java.io.IOException;

public class ColumnHandler implements ChainOfResponsibility{
    private int size;

    public ColumnHandler(int size)
    {
        this.size = size;
    }

    @Override
    public void write(Vehicle vehicle) {
        if (vehicle.getSize()>this.size)
        {
            String names[] =  vehicle.getAllModelsName();
            double prices[] = vehicle.getAllModelsPrice();
            System.out.println("Model brand: " + vehicle.getBrand());
            for (int i = 0; i<vehicle.getSize();i++)
            {
                System.out.println("Model name: "+names[i]+"price is: " + prices[i]);
            }
        }
    }

    @Override
    public void setHandler(ChainOfResponsibility handler) {

    }
}
