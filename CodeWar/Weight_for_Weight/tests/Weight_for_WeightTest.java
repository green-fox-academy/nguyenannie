import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Weight_for_WeightTest {
    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals("2000 103 123 4444 99", Weight_for_Weight.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999", Weight_for_Weight.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }

    @Test
    void sumDigit() {
    }

}