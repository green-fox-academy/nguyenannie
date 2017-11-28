import java.util.*;

public class Anagram {
    public static void main(String[] args) {
        String s1 = "Annie123";
        String s2 = "421einnA";
        System.out.println(checkAnagram(s1,s2));

    }

    public static boolean checkAnagram(String one, String two) {
        if(one.equals(reverseString(two))) {
            return true;
        } else {
            return false;
        }
    }


    public static String reverseString(String input) {
        for (int i = 0; i < input.length(); i++) {
            input = input.substring(1, input.length() - i) + input.charAt(0) + input.substring(input.length() - i);
        }
        return input;
    }
}
