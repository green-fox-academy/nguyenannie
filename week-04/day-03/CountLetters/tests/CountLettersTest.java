import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {
    CountLetters countLetters = new CountLetters();
    @Test
    public void countLetters() throws Exception {
        String myName = "aaaaannieee";
        HashMap<Character,Integer> dict = new HashMap<Character,Integer>(){{put('a',5);put('n',2);put('i',1);put('e',3);}};
        assertEquals(dict, countLetters.countLetters(myName));
    }

}