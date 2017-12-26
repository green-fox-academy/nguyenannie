package gradle.tryouts;

import java.time.LocalDate;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.swapCase(Arrays.toString(args)));
        System.out.println(LocalDate.of(1995,05,27));
    }
}
