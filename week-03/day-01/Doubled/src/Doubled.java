import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Doubled {
    public static void main(String[] args) {
        String fileName = "/Users/annie/greenfox/nguyenannie/week-03/day-01/Doubled/duplicated-chars.txt";
        Double(fileName);
    }

    public static void Double(String fileName) {
        try {
            Path path = Paths.get(fileName);
            Path newPath = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/Doubled/decrypted.txt");
            List<String> message = Files.readAllLines(path);
            List<String> decrypted = new ArrayList<String>();
            for (int i = 0; i < message.size(); i++) {
                String line = message.get(i);
                String newLine = removeDuplicate(line);
                decrypted.add(newLine);
            }
            Files.write(newPath,decrypted);
            System.out.print("Message decrypted!");

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static String removeDuplicate(String dup){
        StringBuilder astring = new StringBuilder(dup);
        for(int i = 0; i < astring.length()- 1; i++){
            if(astring.charAt(i) == astring.charAt(i + 1)){
                astring.deleteCharAt(i + 1);
            }
        }
        dup = astring.toString();
        return dup;
    }

}
