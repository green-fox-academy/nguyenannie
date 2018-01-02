import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        findUpperCase("Annie has two Cats : Rubrub and Sony");
    }

    static void findUpperCase(String str) {
        Stream.of(str.split("[ \\t\\r\\n\\f:*+]*"))
                .filter(s -> s.toUpperCase().equals(s))
                .forEach(System.out::print);
    };
}
