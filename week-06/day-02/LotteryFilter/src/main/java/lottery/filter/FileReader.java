package lottery.filter;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private String filePath;
    private CSVReader csvReader = null;

    FileReader(String filePath) {
        this.filePath = filePath;
    }

    private File file = Paths.get(filePath).toFile();

    private final CSVParser parser =
            new CSVParserBuilder()
                    .withSeparator(';')
                    .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                    .build();


    public List<String[]> readFile() throws IOException {
        List<String[]> allRows = new ArrayList<>();
        try {
            csvReader = new CSVReaderBuilder(new java.io.FileReader(file)).withCSVParser(parser).build();
            allRows = csvReader.readAll();
        } catch (FileNotFoundException e) {
            System.err.println("Error in reading CSV: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error in print Stack Trace: " + e.getMessage());
        }
        finally {
            csvReader.close();
        }

        return allRows;
    }
}
