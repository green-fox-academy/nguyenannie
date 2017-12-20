import java.util.ArrayList;
import java.util.List;

public class UniqueChars {
    public List<String> findUniques(String str) {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            result.add(String.valueOf(str.charAt(i)));
        }

        for(int i = 0; i < result.size(); i++) {
            String x = result.get(i);
            for(int j = i + 1; j < result.size(); j++) {
                if(x.equals(result.get(j))) {
                    result.remove(j);
                }
            }
        }

        for(int i = 0; i < result.size(); i++) {
            if(result.get(i).equals(" ")) {
                result.remove(" ");
            }
        }

        return result;
    }
}
