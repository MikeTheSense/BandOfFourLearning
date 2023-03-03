package learnpatterns.Visitor;

import learnpatterns.Models.Bike;
import learnpatterns.Models.Car;

public interface Visitor {
    void visit(Car car);
    void visit (Bike bike);
}
