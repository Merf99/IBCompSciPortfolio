package Project4;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        File myFile = new File("D:\\CS_project4\\myFile");
        Parser parser = new Parser(myFile);
        //parser.printData();
        Double[] sortedArray = parser.sortAscending();


        Writer writer = new Writer("output");
        //writer.writeData("message");
        writer.writeArrayData(sortedArray);

    }
}
