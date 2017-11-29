import java.io.File;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class PrintEachLine {
    public static void main(String[] args) {
        try {
            Path myPath = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/PrintEachLine/lineExample.txt");
            List<String> myFile = Files.readAllLines(myPath);

            for(int i = 0; i < myFile.size(); i++) {
                System.out.println(myFile.get(i));
            }
        } catch (Exception e) {
            System.out.print("Unable to read file: lineExample.txt");
        }

    }
}
