import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {
    Anagram anagram = new Anagram();
    String str1 = "Annie";
    String str2 = "einnA";

    @Test
    public void checkAnagram() throws Exception {
        assertEquals(true,anagram.checkAnagram(str1,str2));
    }
}