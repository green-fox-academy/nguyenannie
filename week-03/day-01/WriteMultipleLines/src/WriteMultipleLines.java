import java.nio.file.*;
import java.util.*;
import java.io.IOException;

public class WriteMultipleLines {
    public static void main(String[] args) {
        String path = "/Users/annie/greenfox/nguyenannie/week-03/day-01/WriteMultipleLines/writeMultipleLines.txt";
        String word = "apple";
        int lineNum = 5;

        writeMultipleLines(path,word,lineNum);

    }
    public static void writeMultipleLines(String path, String word, int lineNum) {
        List<String> list = new ArrayList<String>();
        Path myPath = Paths.get(path);
        try {
            for(int i = 0; i < lineNum; i++) {
                list.add(word);
            }
            Files.write(myPath, list);
            System.out.println("Already write your file!");
        } catch (Exception e) {
                System.out.println(e);
        }
    }
}
