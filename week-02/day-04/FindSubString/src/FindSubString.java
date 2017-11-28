import java.util.*;

public class FindSubString {
    public static void main(String[] args) {
        String s1 = "this is what I'm searching in";
        String s2 = "searching";

        System.out.print(findSubString(s1,s2));

    }
    public static int findSubString(String one,String two) {
        int k = 0;
        for(int i= 0; i < one.length() - two.length() + 1; i++) {
            if(one.substring(i, i + two.length()).equals(two)) {
                k = i;
                break;
            } else {
                k = -1;
            }
        }
        return k;
    }
}
