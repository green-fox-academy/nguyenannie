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

    CoordinateReader(String filePath) throws FileNotFoundException {
        file = Paths.get(filePath).toFile();
        parser =
                new CSVParserBuilder()
                        .withSeparator(';')
                        .withFieldAsNull(CSVReaderNullFieldIndicator.NEITHER)
                        .build();
    }

    private void setCsvReader() throws FileNotFoundException {
        csvReader = new CSVReaderBuilder(new java.io.FileReader(file)).withCSVParser(parser).build();
    }

    private CSVReader getCsvReader() {
        return csvReader;
    }

    public Coordinate findCoordinate(String countryCode) throws IOException {
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
            csvReader.close();
        }
        return coordinate;
    }

}
