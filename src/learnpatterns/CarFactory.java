package learnpatterns;

import learnpatterns.Models.Car;


public class CarFactory implements TransportFactory {
    @Override
    public Vehicle createInstance(String brand, int size) {
        return new Car(brand,size);
    }
}
