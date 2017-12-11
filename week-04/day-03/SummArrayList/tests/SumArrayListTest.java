import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SumArrayListTest {
    SumArrayList sumArrayList = new SumArrayList();
    @Test
    public void sum() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1,2,3));
        assertEquals(6,sumArrayList.sum(arrayList));
    }

    @Test
    public void sumEmptyList() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>();
        assertEquals(0,sumArrayList.sum(arrayList));
    }

    @Test
    public void sumOneElementList() throws Exception {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1));
        assertEquals(1,sumArrayList.sum(arrayList));
    }
}