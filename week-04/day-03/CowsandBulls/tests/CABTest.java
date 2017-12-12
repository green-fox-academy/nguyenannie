import org.junit.Test;

import static org.junit.Assert.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class CABTest {
    CAB cab = new CAB();

    @Test
    public void testCAB_Constructor(){
        assertEquals(true,cab.playing);
    }

    @Test
    public void guess1() throws Exception {
        String playerGuess = "2345";
        String toGuess = "2345";
        assertArrayEquals(new int[]{4,0},cab.guess(playerGuess,toGuess));
    }

    @Test
    public void guess2() throws Exception {
        String playerGuess = "7416";
        String toGuess = "7531";
        assertArrayEquals(new int[]{1,1},cab.guess(playerGuess,toGuess));
    }



}