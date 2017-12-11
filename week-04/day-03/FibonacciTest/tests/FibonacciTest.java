import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    public void findnFibonacci1() throws Exception {
        assertEquals(55,fibonacci.findnFibonacci(10));
    }

    @Test
    public void findnFibonacci2() throws Exception {
        assertEquals(6765,fibonacci.findnFibonacci(20));
    }

}