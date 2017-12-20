import java.util.Scanner;

public class NameFromEmail {

    String nameFromEmail(String s) {
        String result = "";
        String lastName = "";
        String firstName = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '@') {
                result = s.substring(0, i);
                break;
            }
        }

        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '.') {
                firstName = result.substring(0, i);
                lastName = result.substring(i + 1, result.length());
                break;
            }
        }

        result = firstName + " " + lastName;
        return result;
    }
}
