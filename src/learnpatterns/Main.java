package learnpatterns;
import learnpatterns.ChainOfResponsibility.ChainOfResponsibility;
import learnpatterns.ChainOfResponsibility.ColumnHandler;
import learnpatterns.ChainOfResponsibility.LineHandler;
import learnpatterns.Command.CarCommandColumnPrinter;
import learnpatterns.Command.CarCommandLinePrinter;
import learnpatterns.Models.Bike;
import learnpatterns.Models.Car;
import learnpatterns.Strategy.CalculationNumberOfOccurens;
import learnpatterns.Strategy.CalculationNumberOfOccurensAlgorithmImplementation;
import learnpatterns.Strategy.CalculationNumberOfOccurensMapImplementation;
import learnpatterns.Visitor.Visitor;
import learnpatterns.Visitor.VisitorImplementation;

import java.io.*;
import java.lang.management.MemoryNotificationInfo;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
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

        //1 Chain of Respons.
/*        ChainOfResponsibility chain = new LineHandler(3);
        chain.setHandler(new ColumnHandler(3));
        chain.write(VehicleOperations.createInstance("Mikebisu",3));
        chain.write(VehicleOperations.createInstance("Mikesuzu",5));
        chain.write(VehicleOperations.createInstance("MikeHonda",1));
        VehicleOperations.setFactory(new BikeFactory());
        chain.write(VehicleOperations.createInstance("MikeMW",3));
        chain.write(VehicleOperations.createInstance("Mikeyota",5));
        chain.write(VehicleOperations.createInstance("MikeDA",1));*/

        //Printer #2
        Car car = new Car("mode",3);

/*        car.setCommand(new CarCommandLinePrinter());
        try {car.print(new FileOutputStream("src/Resources/exm.txt"));}
        catch (Exception e) {e.printStackTrace();}*/

        //Iterator<Car.Model> itt = car.iterator();

        //Itterator #3
//        var iterator = car.iterator();
//        while(iterator.hasNext())
//        {
//            Object gotModel = iterator.next();
//            System.out.println(gotModel.toString());
//        }
        //Memento #4
/*        try
        {
            Car.Memento carMemento = car.createMemento();
            Vehicle memCar = (Car) car.setMemento(carMemento);
            VehicleOperations.printModelsInfo(memCar);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/



        //Strategy #6
        CalculationNumberOfOccurens calc = new CalculationNumberOfOccurensMapImplementation();
        CalculationNumberOfOccurens calc2 = new CalculationNumberOfOccurensAlgorithmImplementation();

        int[] array = new int[]{
                1,1,2,4,2,5,4,6,5,4,3,4,5,6,7,8,9,7,5,4,3,2,1,4,5,6,7,8,9,0,0
        };
        //ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(args[1]));
        //ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(args[1]));
        Map<Integer, Integer> map = calc.calculate(array);
        Map<Integer, Integer> map2 = calc.calculate(array);
        for (var entry : map.entrySet())
        {
            System.out.println("Элемент "+ entry.getKey() + " встретился " + entry.getValue());
        }
        for (var entry : map2.entrySet())
        {
            System.out.println("Элемент "+ entry.getKey() + " встретился " + entry.getValue());
        }

        //Visitor #9
        Visitor visitor = new VisitorImplementation();
        Vehicle vehicle1 = new Car("mode",3);
        Vehicle vehicle2 = new Bike("mode",3);
        vehicle1.accept(visitor);
        vehicle2.accept(visitor);

    }
}
