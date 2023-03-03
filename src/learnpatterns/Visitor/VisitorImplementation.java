package learnpatterns.Visitor;

import learnpatterns.Models.Bike;
import learnpatterns.Models.Car;

public class VisitorImplementation implements Visitor {
    public void visit(Car car)
    {
        String[] names = car.getAllModelsName();
        double[] prices = car.getAllModelsPrice();
        for (int i = 0; i<names.length;i++)
        {
            System.out.println("Название модели "+names[i] + " " + "цена "+prices[i]);
        }
    }
    public void visit (Bike bike)
    {
        String[] names = bike.getAllModelsName();
        double[] prices = bike.getAllModelsPrice();
        for (int i = 0; i<names.length;i++)
        {
            System.out.println("Название модели "+names[i] + " " + "цена "+prices[i]);
        }
    }
}
