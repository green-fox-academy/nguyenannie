import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCharsTest {
    @Test
    void findUniques1() {
        assertEquals(Arrays.asList("n", "g", "r", "m"),UniqueChars.findUniques("anagram"));
    }

    @Test
    void findUniques2() {
        assertEquals(Arrays.asList("d", "e", "f"),UniqueChars.findUniques("aaaabbbbbccccdefggggg"));
    }

    @Test
    void findUniques3() {
        assertEquals(Arrays.asList(),UniqueChars.findUniques(""));
    }

}