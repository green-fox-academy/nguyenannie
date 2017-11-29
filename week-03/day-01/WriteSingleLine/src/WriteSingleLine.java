import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class WriteSingleLine {
    public static void main(String[] args) {
        List<String> myText = new ArrayList<String>();
        myText.add("This is my first line!");
        try {
            Path filePath = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/WriteSingleLine/writeLine.txt");
            Files.write(filePath,myText);

        } catch (Exception e) {
            System.out.print("Unable to write file: writeLine.txt");
        }
    }
}
