package learnpatterns.ChainOfResponsibility;

import learnpatterns.Vehicle;

import java.io.IOException;


public interface ChainOfResponsibility {
    void write (Vehicle vehicle);
    void setHandler(ChainOfResponsibility handler);
}
