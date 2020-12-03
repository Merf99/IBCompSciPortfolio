package Project4;

import java.io.File;

public class Main {
    public static void main(String[] args){

        File myFile = new File("put file path here (CSV file)");
        Parser parser = new Parser(myFile);
        parser.printData();
    }
}
