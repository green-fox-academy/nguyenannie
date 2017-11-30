import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class EncodedLines {
    public static void main(String[] args) {
        String pathName = "/Users/annie/greenfox/nguyenannie/week-03/day-01/EncodedLines/encoded-lines.txt";
        decoded(pathName);

    }

    public static void decoded(String pathName) {
        try {
            Path path1 = Paths.get(pathName);
            Path path2 = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/EncodedLines/decrypted.txt");
            List<String> message = Files.readAllLines(path1);
            List<String> decrypted = new ArrayList<String>();

            for(int i = 0; i < message.size(); i++) {
                String line = message.get(i);
                String difLine = cypher(line);
                decrypted.add(difLine);
            }
            Files.write(path2,decrypted);
            System.out.print("Message decrypted!");
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    /*
    public static String cypher(String aString) {
        int shift = -1;
        String newString = "";

        for(int i = 0; i < aString.length(); i++) {
            if(aString.charAt(i) == ' '){
                newString = newString + " ";
            } else {
                char key = aString.charAt(i);
                int k = (int) key;
                k = k - 1;
                if (k < (int) 'A') {
                    k += 58;
                }
                char keyX = (char) k;
                newString = newString + keyX;
            }
        }
        return newString;
    }
    */

    public static String cypher(String aString) {
        StringBuilder foo = new StringBuilder(aString);
        for(int i = 0; i < foo.length(); i++) {
            if(foo.charAt(i) == ' '){
                foo.setCharAt(i, ' ');
            } else if(foo.charAt(i) == '/') {
                foo.setCharAt(i, '.');
            } else {
                char key = foo.charAt(i);
                int k = (int) key;
                k = k -1;
                if(k <(int) 'A'){
                    k = k + 58;
                }
                char keyX = (char) k;
                foo.setCharAt(i, keyX);
            }
        }
        String result = foo.toString();
        return result;

    }
}
