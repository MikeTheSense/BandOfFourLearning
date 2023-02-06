package learnpatterns;
import learnpatterns.Models.Bike;

public class BikeFactory implements TransportFactory {
    @Override
    public Vehicle createInstance(String brand, int size) {
        return new Bike(brand,size);
    }
}
