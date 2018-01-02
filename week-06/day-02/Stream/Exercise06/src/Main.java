import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println(findFrequencyOfSpecificChar("Rubrub is a bad cat and soni is the same", 'b'));
        findFrequency("abaaabbbccdddc");
    }

    public static long findFrequencyOfSpecificChar(String str, Character c){
        return Stream.of(str.split("[\\s\\t\\r\\n\\f:*+]*"))
                .filter(s -> s.equals(c.toString()))
                .count();
    }

    public static void findFrequency(String str) {
        System.out.println(Stream.of(str.split("[\\s\\t\\r\\n\\f:*+]*"))
                                .collect(Collectors.groupingBy(s -> s, Collectors.counting())));
    }
}
