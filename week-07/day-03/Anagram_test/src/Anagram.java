import java.util.Arrays;

public class Anagram {
    public static boolean isAnagram(String stringinput1, String stringinput2) {
        if (stringinput1 == null || stringinput2 == null) {
            return false;
        }
        char[] chars1 = stringinput1.toCharArray();
        Arrays.sort(chars1);
        String sorted1 = new String(chars1);
        char[] chars2 = stringinput2.toCharArray();
        Arrays.sort(chars2);
        String sorted2 = new String(chars2);

        if (sorted1.equals(sorted2)) {
            return true;
        }
        return  false;
    }
}
