import java.util.*;

public class IsInList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));

        // Check if list contains all of the following elements: 4,8,12,16
        // Print "true" if it contains all, otherwise print "false"
        // Can you do both the different approaches you tried in the previous one
        /*
        if(list.contains(4) && list.contains(8) && list.contains(12) && list.contains(16)) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
        */
        int g = 0;

        for(int i = 0; i < list.size(); i++) {
            int k = list.get(i);
            if(k == 4 || k ==8 || k ==12 || k == 16) {
                g = g + 1;
            }
        }
        if(g == 4) {
            System.out.print(true);
        } else {
            System.out.print(false);
        }
    }
}
