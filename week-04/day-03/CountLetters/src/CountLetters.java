import java.util.HashMap;

public class CountLetters {
    public HashMap<Character, Integer> countLetters(String str) {
        HashMap<Character, Integer> dictionary = new HashMap<>();
        for(int i = 0; i < str.length(); i ++) {
            if(!dictionary.containsKey(str.charAt(i))) {
                dictionary.put(str.charAt(i),1);
            } else {
                dictionary.put(str.charAt(i), dictionary.get(str.charAt(i)) + 1);
            }
        }
        return dictionary;
    }
}
