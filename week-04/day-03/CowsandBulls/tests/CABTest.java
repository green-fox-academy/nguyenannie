import org.junit.Test;

import static org.junit.Assert.*;
import java.lang.reflect.*;

public class CABTest {
    CAB cab = new CAB();

    @Test
    public void testCAB_Constructor(){
        assertEquals(true,cab.playing);
        assertEquals(0,cab.counter);
    }

    @Test
    public void guess() throws Exception {

    }

}