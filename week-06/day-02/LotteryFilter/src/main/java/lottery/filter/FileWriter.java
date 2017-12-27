package lottery.filter;

import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileWriter {
    private Writer writer;
    private CSVWriter csvWriter;

    public FileWriter(String filePath) throws IOException {
        writer = new java.io.FileWriter(filePath);
        csvWriter =
                new CSVWriter(writer, ';', CSVWriter.NO_QUOTE_CHARACTER,
                        CSVWriter.NO_ESCAPE_CHARACTER, "\n");
    }

    public void writeFile(List<String[]> allLines) throws IOException {
        csvWriter.writeAll(allLines);
        writer.close();
    }
}
