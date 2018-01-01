package weather.checker;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

import java.io.*;
import java.nio.file.Paths;

public class CoordinateReader {
    private CSVReader csvReader = null;
    private File file;
    private CSVParser parser;

    CoordinateReader(String filePath) {
        file = Paths.get(filePath).toFile();
        parser =
                new CSVParserBuilder()
                        .withSeparator(';')
                        .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                        .build();
    }

    private void setCsvReader() {
        try {
            csvReader = new CSVReaderBuilder(new FileReader(file)).withCSVParser(parser).build();
        } catch (FileNotFoundException e) {
            System.out.println("Can not find the file.");
        }
    }

    private CSVReader getCsvReader() {
        return csvReader;
    }

    public Coordinate findCoordinate(String countryCode) {
        String[] line;
        Coordinate coordinate = new Coordinate(new String[2]);
        setCsvReader();

        try {
            while ((line = getCsvReader().readNext()) != null) {
                if(line[0].equals(countryCode)) {
                    coordinate.lat = line[1];
                    coordinate.lng = line[2];
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error in reading CSV: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error in printing stack trace: " + e.getMessage());
        } finally {
            try {
                csvReader.close();
            } catch (IOException e) {
                System.err.println("Error in printing stack trace: " + e.getMessage());
            }
        }
        return coordinate;
    }

}
