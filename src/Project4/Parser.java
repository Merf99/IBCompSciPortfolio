package Project4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parser {
    public Scanner scanner;

    public Parser(File file)  {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("file was not found");
            e.printStackTrace();
        }
    }

    public void printData(){
        while (scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }

}
