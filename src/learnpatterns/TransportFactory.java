package learnpatterns;

public interface TransportFactory {
    Vehicle createInstance(String brand, int size);
}
