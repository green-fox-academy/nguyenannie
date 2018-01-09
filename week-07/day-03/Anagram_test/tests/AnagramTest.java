import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    @Test
    public void should_returnTrue_when_twoStringsContaintheSameCharacters() {
        String original1 = "aba";
        String comparison1 = "aab";
        String original2 ="tot";
        String comparison2 = "ott";
        String original3 ="toti";
        String comparison3 = "otti";

        boolean result1 = Anagram.isAnagram(original1, comparison1);
        boolean result2 = Anagram.isAnagram(original2, comparison2);
        boolean result3 = Anagram.isAnagram(original3, comparison3);

        assertTrue(result1);
        assertTrue(result2);
        assertTrue(result3);
    }

    @Test
    public void should_returnFalse_when_twoStringsContainDifferentCharacters() {
        String original ="lol";
        String comparison = "ott";

        boolean result = Anagram.isAnagram(original, comparison);

        assertFalse(result);
    }


    @Test
    public void should_returnFalse_when_twoStringswiththeSameCharacters_but_notSameAmountofCharacters() {
        String original ="tot";
        String comparison = "otto";

        boolean result = Anagram.isAnagram(original, comparison);

        assertFalse(result);
    }

    @Test
    public void should_returnFalse_when_oneStringisNull() {
        String original ="";
        String comparison = null;

        boolean result = Anagram.isAnagram(original, comparison);

        assertFalse(result);
    }

}
