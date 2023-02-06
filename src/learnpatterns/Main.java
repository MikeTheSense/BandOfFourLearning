package learnpatterns;

import learnpatterns.Models.Bike;

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




        VehicleOperations.setFactory(new CarFactory());
        Vehicle vehicle2 = VehicleOperations.createInstance("mikolaka",2);
        try {
            Vehicle copiedVehicle = vehicle2.clone();
           copiedVehicle.setBrandName("MIKOLA_CUSTOMS");
           copiedVehicle.setPriceByModelName("default 1", 222);
            copiedVehicle.setPriceByModelName("default 2", 2223);

            System.out.println(copiedVehicle.getBrand());
            VehicleOperations.printModelsInfo(copiedVehicle);


            System.out.println("Изначальный обьект");
            System.out.println(vehicle2.getBrand());
            VehicleOperations.printModelsInfo(vehicle2);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        //vehicle1.clone();
        VehicleOperations.setFactory(new BikeFactory());
        Vehicle vehicle3 = VehicleOperations.createInstance("MIKE THE DESTROYER",2);

        System.out.println("COPYING BIKE");


        try {
            Vehicle copiedVehicle2 = vehicle3.clone();
            copiedVehicle2.setBrandName("MIKOLA_CUSTOMS");
//            copiedVehicle2.setPriceByModelName("default 1", 222);
//            copiedVehicle2.setPriceByModelName("default 2", 2223);

            System.out.println(copiedVehicle2.getBrand());
            VehicleOperations.printModelsInfo(copiedVehicle2);


            System.out.println("Изначальный обьект");
            System.out.println(vehicle3.getBrand());
            VehicleOperations.printModelsInfo(vehicle3);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        /*
        VehicleOperations.printModelsInfo(vehicle);
        VehicleOperations.printModelsInfo(vehicle1);

         */



    }
}
