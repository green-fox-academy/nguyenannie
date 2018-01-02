import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(convertToString(new char[]{'r', 'u', 'b', 'b', 'l', 'e'}));
    }

    public static String convertToString(char[] chars) {
        List<String> listOfStrings = Stream.of(chars).map(String::valueOf).collect(Collectors.toList());
        return listOfStrings.stream().collect(Collectors.joining());
    }
}
