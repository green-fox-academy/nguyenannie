package weather.checker;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WeatherReader {
    private CSVReader csvReader = null;
    private String filePath;
    private File file;
    private CSVParser parser;

    WeatherReader(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        file = Paths.get(filePath).toFile();
        parser =
                new CSVParserBuilder()
                        .withSeparator(';')
                        .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                        .build();
    }

    public void setCsvReader() throws FileNotFoundException {
        csvReader = new CSVReaderBuilder(new java.io.FileReader(file)).withCSVParser(parser).build();
    }

    public CSVReader getCsvReader() {
        return csvReader;
    }

    public String[] findCoordinate(String countryCode) throws IOException {
        String[] line;
        String[] coordinate = new String[2];
        setCsvReader();
        try {
            while ((line = getCsvReader().readNext()) != null) {
                if(line[0].equals(countryCode)) {
                    coordinate[0] = line[1];
                    coordinate[1] = line[2];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error in reading CSV: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error in printing stack trace: " + e.getMessage());
        } finally {
            csvReader.close();
        }
        return coordinate;
    }

}
