import java.util.ArrayList;
import java.util.List;

public class AllLongestString {
    static String[] allLongestStrings(String[] inputArray) {
        List<String> list = new ArrayList<>();
        int longest = inputArray[0].length();
        for(String str:inputArray) {
            if(str.length() > longest) {
                longest = str.length();
            }
        }

        for(String str:inputArray) {
            if(str.length() == longest) {
                list.add(str);
            }
        }

        String[] result = new String[list.size()];

        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

}
