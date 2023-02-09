package learnpatterns;

import learnpatterns.Adapter.StringToSeparetedByteStreamAdapter;
import learnpatterns.Adapter.StringToStreamAdapter;
import learnpatterns.Exceptions.DuplicateModelNameException;
import learnpatterns.Models.Bike;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String[] array = new String[] {"Хапани дружок","ПЕПЕ","ДЫ"};
        StringToStreamAdapter ssta = new StringToSeparetedByteStreamAdapter();
        String filename = "src/Resources/out";
        try {
            ssta.convertStringToStream(array, new FileOutputStream(filename));
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
            while (br.ready()) System.out.println(br.readLine());
            br.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }






    }
}
