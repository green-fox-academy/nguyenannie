import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class ReversedLines {
    public static void main(String[] args) {
        String filePath = "/Users/annie/greenfox/nguyenannie/week-03/day-01/ReversedLines/reversed-lines.txt";
        reversedLines(filePath);
    }

    public static void reversedLines(String filePath){
        try{
            Path path = Paths.get(filePath);
            Path newPath = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/ReversedLines/decrypted.txt");
            List<String> message = Files.readAllLines(path);
            List<String> decryptedMessage = new ArrayList<String>();

            for(int i = 0; i < message.size(); i ++ ){
                String line = message.get(i);
                String decryptedLine = reverseString(line);
                decryptedMessage.add(decryptedLine);
            }
            Files.write(newPath,decryptedMessage);
            System.out.print("Message decrypted!");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static String reverseString(String reverse){
        StringBuilder astring = new StringBuilder(reverse).reverse();
        return astring.toString();
    }


}
