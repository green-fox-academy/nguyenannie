import java.util.ArrayList;
import java.util.List;

public class UniqueChars {

    public static List<String> findUniques(String str) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            boolean b = true;
            for(int j = 0; j < str.length(); j++) {
                if(x == str.charAt(j) && i != j) {
                    b = false;
                    break;
                }
            }
            if(b) {
                result.add(String.valueOf(x));
            }
        }
        return result;
    }
}
