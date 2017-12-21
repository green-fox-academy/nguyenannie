import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllLongestStringTest {
    @Test
    void allLongestStrings_1() {
        String[] inputArray = {"aba", "aa", "ad", "vcd", "aba"};
        String[] resultArray = {"aba", "vcd", "aba"};
        assertArrayEquals(resultArray,AllLongestString.allLongestStrings(inputArray));
    }

    @Test
    void allLongestStrings_2() {
        String[] inputArray = {"aa"};
        String[] resultArray = {"aa"};
        assertArrayEquals(resultArray,AllLongestString.allLongestStrings(inputArray));
    }

    @Test
    void allLongestStrings_3() {
        String[] inputArray = {"abc", "eeee", "abcd", "dcd"};
        String[] resultArray = {"eeee", "abcd"};
        assertArrayEquals(resultArray,AllLongestString.allLongestStrings(inputArray));
    }

    @Test
    void allLongestStrings_4() {
        String[] inputArray = {"a", "abc", "cbd", "zzzzzz", "a", "abcdef", "asasa", "aaaaaa"};
        String[] resultArray = {"zzzzzz", "abcdef", "aaaaaa"};
        assertArrayEquals(resultArray,AllLongestString.allLongestStrings(inputArray));
    }
}