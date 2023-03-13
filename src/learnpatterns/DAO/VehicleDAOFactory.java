package learnpatterns.DAO;

import learnpatterns.Vehicle;

public class VehicleDAOFactory {
    public static VehicleDAO getVehicleDAO(String filename){
        if (filename.contains(".txt")){
            return new VehicleDAOTextImpl(filename);
        }else{
            return new VehicleDAOSerializedImpl(filename);
        }
    }
}
