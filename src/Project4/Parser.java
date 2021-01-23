package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    public Scanner scanner;
    int numValue=5;
    public Double[] unsortedValues = new Double[numValue];

    public Parser(File file)  {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file was not found");
            e.printStackTrace();
        }
        readDataIntoArray();
    }

    public void printData(){
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }

  //  public double findAverage{



    public void readDataIntoArray(){
        for (int i = 0; i < numValue; i++) {
            unsortedValues[i]=Double.valueOf(scanner.next());
           // System.out.println(unsortedValues.toString());
        }
    }

    public Double[] sortAscending(){
        BubbleSorter bs = new BubbleSorter();
        return bs.sort(unsortedValues);

    }
}
