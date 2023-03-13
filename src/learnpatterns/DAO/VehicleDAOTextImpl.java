package learnpatterns.DAO;

import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Vehicle;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class VehicleDAOTextImpl implements VehicleDAO{
    private String sourceFileName;

    public VehicleDAOTextImpl(String source) {
        this.sourceFileName = source;
    }

    @Override
    public Vehicle readObject(Vehicle vehicle)  {
       try(Scanner reader = new Scanner(new FileReader(sourceFileName))) {
           String  brand  = reader.nextLine();
           int  quantity  = Integer.parseInt(reader.nextLine());
           vehicle.setBrandName(brand);
           for (int i = 0; i<quantity;i++)
           {
               vehicle.addNewModel(reader.nextLine(),Double.parseDouble(reader.nextLine()));
           }
           return vehicle;
       } catch (FileNotFoundException fileNotFoundException) {
           fileNotFoundException.printStackTrace();
       } catch (DuplicateModelNameException e) {
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public void writeObject(Vehicle vehicle) {
        try (PrintWriter printWriter = new PrintWriter(new FileWriter(sourceFileName));) {
            printWriter.println(vehicle.getBrand());
            printWriter.println(vehicle.getSize());
            String[] names = vehicle.getAllModelsName();
            double[] prices = vehicle.getAllModelsPrice();

            for (int i = 0; i < vehicle.getSize(); i++) {
                printWriter.println(names[i]);
                printWriter.println(prices[i]);
            }
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    public Vehicle readObject()  {
//        try(Scanner reader = new Scanner(new FileReader(sourceFileName))) {
//            String classType  = reader.next();
//            Vehicle vehicle = (Vehicle) Class.forName(classType).getDeclaredConstructor().newInstance();
//            String  brand  = reader.next();
//            int  quantity  = reader.nextInt();
//            vehicle.setBrandName(brand);
//            for (int i = 0; i<quantity;i++)
//            {
//                vehicle.addNewModel(reader.next(),reader.nextDouble());
//            }
//            return vehicle;
//        } catch (FileNotFoundException | ClassNotFoundException | NoSuchMethodException fileNotFoundException) {
//            fileNotFoundException.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (DuplicateModelNameException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

//    @Override
//    public void writeObject(Vehicle vehicle) {
//        try (PrintWriter printWriter = new PrintWriter(new FileWriter(sourceFileName));) {
//            printWriter.println(vehicle.getClass());
//            printWriter.println(vehicle.getBrand());
//            printWriter.println(vehicle.getSize());
//            String[] names = vehicle.getAllModelsName();
//            double[] prices = vehicle.getAllModelsPrice();
//
//            for (int i = 0; i < vehicle.getSize(); i++) {
//                printWriter.println(names[i]);
//                printWriter.println(prices[i]);
//            }
//            printWriter.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
