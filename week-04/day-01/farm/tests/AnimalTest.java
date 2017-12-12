import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
    Animal animal = new Animal();
    @Test
    public void testInput(){
        assertEquals(50,animal.hunger);
        assertEquals(50,animal.thirst);
    }

}