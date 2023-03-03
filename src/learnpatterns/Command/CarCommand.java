package learnpatterns.Command;

import learnpatterns.Models.Car;

import java.io.PrintWriter;

public interface CarCommand {
   void print(PrintWriter printWriter, Car car);
}
