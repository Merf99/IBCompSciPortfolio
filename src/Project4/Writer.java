package Project4;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private FileWriter writer;

    public Writer(String fileName) {
        try {
            writer = new FileWriter(fileName);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData(String data) throws IOException {
        writer.write(data);
        writer.close();

    }

    public void writeArrayData(Double[] arrayData) throws IOException{
        for (int i = 0; i < arrayData.length; i++) {
            writer.write(arrayData[i].toString()+"\n");
        }
        writer.close();
    }
}
