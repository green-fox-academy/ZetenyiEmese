import org.junit.Test;

import static org.junit.Assert.*;

public class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void testCountFibonacciWithDifferentNumbers() {
        int n1 = 0;
        int n2 = 1;
        int n3 = 5;
        int n4 = 50;
        long expected1 = 0L;
        long expected2 = 1L;
        long expected3 = 5L;
        long expected4 = 12586269025L;

        long result1 = fibonacci.countFibonacci(n1);
        long result2 = fibonacci.countFibonacci(n2);
        long result3 = fibonacci.countFibonacci(n3);
        long result4 = fibonacci.countFibonacci(n4);

        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
    }

    @Test
    public void testCountFibonacciWithNegative() {
        int n = -5;
        long expected = 0;

        long result = fibonacci.countFibonacci(-1);

        assertEquals(expected, result);
    }

}
