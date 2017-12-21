import java.util.ArrayList;
import java.util.List;

class UniqueChars {

    static List<String> findUniques(String str) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < str.length(); i++) {
            char x = str.charAt(i);
            boolean isUnique = true;
            for(int j = 0; j < str.length(); j++) {
                if(x == str.charAt(j) && i != j) {
                    isUnique = false;
                    break;
                }
            }
            if(isUnique) {
                result.add(String.valueOf(x));
            }
        }
        return result;
    }
}
