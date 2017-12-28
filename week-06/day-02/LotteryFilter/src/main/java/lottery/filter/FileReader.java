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
    private CSVReader csvReader = null;
    private File file;
    private CSVParser parser;

    FileReader(String filePath) {
        file = Paths.get(filePath).toFile();
        parser = new CSVParserBuilder()
                    .withSeparator(';')
                    .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                    .build();
    }

    public List<String[]> readFile() throws IOException {
        List<String[]> allLines = new ArrayList<>();

        try {
            csvReader = new CSVReaderBuilder(new java.io.FileReader(file)).withCSVParser(parser).build();
            allLines = csvReader.readAll();
        } catch (FileNotFoundException e) {
            System.err.println("Error in reading CSV: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error in print Stack Trace: " + e.getMessage());
        } finally {
            csvReader.close();
        }

        return allLines;
    }
}