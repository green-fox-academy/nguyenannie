import java.util.*;
import java.nio.file.*;
import java.io.IOException;

public class ReversedOrder {
    public static void main(String[] args) {
        String pathName = "/Users/annie/greenfox/nguyenannie/week-03/day-01/ReversedOrder/reversed-order.txt";
        reversedOrder(pathName);
    }

    public static void reversedOrder(String pathName){
        try{
            Path path1= Paths.get(pathName);
            Path path2 = Paths.get("/Users/annie/greenfox/nguyenannie/week-03/day-01/ReversedOrder/decrypted.txt");
            List<String> message = Files.readAllLines(path1);
            List<String> decryptedMessage = new ArrayList<String>();

            for(int i = message.size() - 1; i >= 0; i--){
                decryptedMessage.add(message.get(i));
            }
            Files.write(path2,decryptedMessage);
            System.out.print("Message decrypted!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
