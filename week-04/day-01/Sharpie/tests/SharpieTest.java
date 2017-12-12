import org.junit.Test;

import static org.junit.Assert.*;

public class SharpieTest {
    @Test
    public void use() throws Exception {
        Sharpie sharpie = new Sharpie("red",80);
        assertEquals("red",sharpie.color);
        assertEquals(80,sharpie.width,0);
        assertEquals(100,sharpie.inkAmount,0);
    }
}