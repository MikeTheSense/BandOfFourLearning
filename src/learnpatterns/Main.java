package learnpatterns;

public class Main {

    public static void main(String[] args) {
	// write your code here
        var pr = PropertiesService.getInstance();
        pr.getProperties();
        var vr = PropertiesService.getInstance();
        vr.getProperties();
        System.out.println(pr.equals(vr));
        System.out.println(pr.getProperties().getProperty("projectName"));
        System.out.println(vr.getProperties().getProperty("projectName"));
        Vehicle vehicle = VehicleOperations.createInstance("mike",10);
        VehicleOperations.setFactory(new CarFactory());
        VehicleOperations.setFactory(new BikeFactory());
        Vehicle vehicle1 = VehicleOperations.createInstance("mikola",5);



        VehicleOperations.printModelsInfo(vehicle);
        VehicleOperations.printModelsInfo(vehicle1);



    }
}
