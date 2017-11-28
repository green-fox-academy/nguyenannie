import java.util.*;

public class AppendLetter {
    public static void main(String[] args) {
            ArrayList<String> far = new ArrayList<String>(Arrays.asList("kuty", "macsk", "kacs", "rók", "halacsk"));
            // Add "a" to every string in the far list.
            for (int i = 0; i < far.size(); i++) {
                String temp = far.get(i);
                temp = temp + "a";
                far.set(i, temp);
            }

            System.out.println(far);
    }
}
