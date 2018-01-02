package lottery.filter;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileWriter {
    private Writer writer;
    private CSVWriter csvWriter;

    public FileWriter(String filePath) {
        try {
            writer = new java.io.FileWriter(filePath);
        } catch (IOException e) {
            System.err.println("Error in print Stack Trace: " + e.getMessage());
        }
        csvWriter =
                new CSVWriter(writer, ';', CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.NO_ESCAPE_CHARACTER, "\n");
    }

    public void writeFile(List<String[]> allLines){
        csvWriter.writeAll(allLines);
        try {
            writer.close();
        } catch (IOException e) {
            System.err.println("Error in print Stack Trace: " + e.getMessage());
        }
    }
}
