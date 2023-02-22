package learnpatterns;

import learnpatterns.Adapter.StringToSeparetedByteStreamAdapter;
import learnpatterns.Adapter.StringToStreamAdapter;
import learnpatterns.ChainOfResponsibility.ChainOfResponsibility;
import learnpatterns.ChainOfResponsibility.ColumnHandler;
import learnpatterns.ChainOfResponsibility.LineHandler;
import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Models.Bike;
import learnpatterns.Models.Car;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String[] array = new String[] {"Хапани дружок","ПЕПЕ","ДЫ"};
//        StringToStreamAdapter ssta = new StringToSeparetedByteStreamAdapter();
//        String filename = "src/Resources/out";
//        try {
//            ssta.convertStringToStream(array, new FileOutputStream(filename));
//            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
//            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
//            while (br.ready()) System.out.println(br.readLine());
//            br.close();
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
        ChainOfResponsibility chain = new LineHandler(3);
        chain.setHandler(new ColumnHandler(3));
        chain.write(VehicleOperations.createInstance("Mikebisu",3));
        chain.write(VehicleOperations.createInstance("Mikesuzu",5));
        chain.write(VehicleOperations.createInstance("MikeHonda",1));
        VehicleOperations.setFactory(new BikeFactory());
        chain.write(VehicleOperations.createInstance("MikeMW",3));
        chain.write(VehicleOperations.createInstance("Mikeyota",5));
        chain.write(VehicleOperations.createInstance("MikeDA",1));













    }
}
