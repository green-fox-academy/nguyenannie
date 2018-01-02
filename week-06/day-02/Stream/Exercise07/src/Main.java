import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList("ROME", "LONDON", "NAIROBI"
                , "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS"));

        numbers.stream()
                .filter(s -> s.startsWith("A") && s.endsWith("I"))
                .forEach(System.out::println);
    }
}
