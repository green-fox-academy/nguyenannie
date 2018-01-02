import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14));

        List<Integer> oddNumbers
                = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        System.out.println(oddNumbers);
    }
}
