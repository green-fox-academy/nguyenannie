import org.junit.Test;

import static org.junit.Assert.*;

public class NumberConverterTest {
    @Test
    public void first() {
        int moneyAmountinNumber = 745;
        String moneyAmountinWord = "seven hundred and fourty five dollars";

        String result = NumberConverter.convertToString(moneyAmountinNumber);

        assertEquals(moneyAmountinWord,result);
    }
}