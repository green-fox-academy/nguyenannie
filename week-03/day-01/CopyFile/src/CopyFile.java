import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class CopyFile {
    public static void main(String[] args) {
        String path1 = "/Users/annie/greenfox/nguyenannie/week-03/day-01/CopyFile/file1.txt";
        String path2 = "/Users/annie/greenfox/nguyenannie/week-03/day-01/CopyFile/file2.txt";

        copyFile(path1,path2);

    }
    public static void copyFile(String file1, String file2){
        Path path1 = Paths.get(file1);
        Path path2 = Paths.get(file2);
        try {
            List<String> content1 = Files.readAllLines(path1);
            Files.write(path2,content1);
            System.out.println("Copy done!");
        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
