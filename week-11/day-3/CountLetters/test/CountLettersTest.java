import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {

    public static CountLetters countLetters;

    @BeforeClass
    public static void init() {
        countLetters = new CountLetters();
    }

    @Test
    public void testCountLetters() {
        String string = "banana";
        HashMap<Character, Integer> expected = new HashMap<>();
        expected.put('b', 1);
        expected.put('a', 3);
        expected.put('n', 2);

        HashMap<Character, Integer> result = countLetters.countLetters(string);

        assertEquals(expected, result);
    }

    @Test
    public void testCountLettersWithEmptyString() {
        String string = "";
        HashMap<Character, Integer> expected = new HashMap<>();

        HashMap<Character, Integer> result = countLetters.countLetters(string);

        assertEquals(expected, result);
    }

    @Test
    public void testCountLettersWithNull() {
        String string = null;
        HashMap<Character, Integer> expected = new HashMap<>();

        HashMap<Character, Integer> result = countLetters.countLetters(string);

        assertEquals(expected, result);
    }

}
