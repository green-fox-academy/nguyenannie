import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Write_Number_in_Expanded_FormTest {
    @Test
    void expandedForm_Test1() {
        assertEquals("10 + 2", Write_Number_in_Expanded_Form.expandedForm(12));
    }

    @Test
    void expandedForm_Test2() {
        assertEquals("40 + 2", Write_Number_in_Expanded_Form.expandedForm(42));
    }

    @Test
    void expandedForm_Test3() {
        assertEquals("70000 + 300 + 4", Write_Number_in_Expanded_Form.expandedForm(70304));
    }
}