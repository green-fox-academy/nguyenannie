package lottery.filter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

public class Main {
    private static final String CSV_FILE_PATH_READER = "otos.csv";
    private static final String CSV_FILE_PATH_WRITER = "output.csv";
    private static List<String[]> newContent = new ArrayList<>();
    private static String year = "";

    public static void main(String[] args) throws IOException {
        OptionParser parser = new OptionParser();
        parser.accepts("y").withRequiredArg();
        parser.accepts("f").withRequiredArg();
        parser.accepts("o").withRequiredArg();
        OptionSet options = parser.parse(args);

        year = (String) options.valueOf("y");
        String inputFile = (String) options.valueOf("f");
        String outputFile = (String) options.valueOf("o");

        if (options.has("o") && options.has("f") && options.has("y")) {
            performTask(inputFile,outputFile);
        } else if(options.has("o") && options.has("y")) {
            performTask(CSV_FILE_PATH_READER,outputFile);
        } else if(options.has("f") && options.has("y")) {
            performTask(inputFile,CSV_FILE_PATH_WRITER);
        } else if (options.has("y")) {
            performTask(CSV_FILE_PATH_READER,CSV_FILE_PATH_WRITER);
        }
    }

    private static void performTask(String inputFile, String outputFile) throws IOException {
        FileReader fileReader = new FileReader(inputFile);
        FileWriter fileWriter = new FileWriter(outputFile);
        List<String[]> allLines = fileReader.readFile();
        for(String[] line : allLines) {
            if(line[0].equals(year)) {
                newContent.add(line);
            }
        }
        fileWriter.writeFile(newContent);
    }
}
