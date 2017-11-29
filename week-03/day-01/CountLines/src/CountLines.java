import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class CountLines {
    public static void main(String[] args) {
        try {
            Path myPath = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/PrintEachLine/lineExample.txt");
            List<String> myFile = Files.readAllLines(myPath);
            int lineNum = 0;
            for(int i = 0; i < myFile.size(); i++) {
                lineNum += 1;
            }
            System.out.println(lineNum);

        } catch (Exception e){
            System.out.println(0);
        }
    }

}
