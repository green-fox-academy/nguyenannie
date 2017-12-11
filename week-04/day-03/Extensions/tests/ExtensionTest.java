import org.junit.Test;

import static org.junit.Assert.*;
import java.util.*;

public class ExtensionTest {
    Extension extension = new Extension();

    @Test
    public void testAdd1() {
        assertEquals(5, extension.add(2, 3));
    }

    @Test
    public void testAdd2() {
        assertEquals(7, extension.add(1, 6));
    }

    @Test
    public void testMaxOfThree1() {
        assertEquals(5, extension.maxOfThree(5, 3, 4));
    }

    @Test
    public void testMaxOfThree2() {
        assertEquals(5, extension.maxOfThree(3, 4, 5));
    }

    @Test
    public void testMedian_Even() {
        assertEquals(5, extension.median(Arrays.asList(7,5,3,5,9,4,8,6)));
    }

    @Test
    public void testMedian_Odd() {
        assertEquals(5, extension.median(Arrays.asList(1,2,3,4,5,6,7,8,9)));
    }

    @Test
    public void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    public void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    public void testTranslate_bemutatkozik() {
        assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    public void testTranslate_kolbice() {
        assertEquals("lavagovopuvusuvu", extension.translate("lagopusu"));
    }

}