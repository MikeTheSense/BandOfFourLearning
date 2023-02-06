package learnpatterns;

public class VehicleOperations {
    private static TransportFactory factory = new CarFactory();
    public static TransportFactory getFactory() {
        return factory;
    }
    public static void setFactory(TransportFactory factory) {
        VehicleOperations.factory = factory;
    }
    
    public static Vehicle createInstance(String brand, int size)
    {
        return factory.createInstance(brand,size);
    }
    
    public static double getAveragePrice(Vehicle vehicle)
    {
        if (vehicle.getSize() > 0) {
            double result = 0;
            double[] prices = vehicle.getAllModelsPrice();
            for (double modelPrice : prices) result += modelPrice;
            return result / prices.length;
        }
        return 0;
    }

    public static void printModelsInfo(Vehicle vehicle)
    {
        if (vehicle.getSize() > 0)
        {
            double prices[] = vehicle.getAllModelsPrice();
            String names[] = vehicle.getAllModelsName();
            for (int i = 0; i < prices.length; i++)
            {
                System.out.println("Model name: " + names[i] + ", model price: " + prices[i] + ";");
            }
        }
    }
}

