import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class SumAppTest {

    private static SumApp app;

    @BeforeClass
    public static void init() {
        app = new SumApp();
    }

    @Test
    public void testSum() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        int expected = 15;

        int result = app.sum(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithEmptyList() {
        ArrayList<Integer> numbers = new ArrayList<>(); //an empty list
        int expected = 0;

        int result = app.sum(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithOneElementInTheList() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(7));
        int expected = 7;

        int result = app.sum(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithMultipleElementsInTheList() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(7, 7, 7, 7, 7));
        int expected = 35;

        int result = app.sum(numbers);

        assertEquals(expected, result);
    }

    @Test
    public void testSumWithNull() {
        ArrayList<Integer> numbers = null;
        int expected = 0;

        int result = app.sum(numbers);

        assertEquals(expected, result);
    }

}