import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnagramTest {

    private static Anagram anagram;

    @BeforeClass
    public static void init() {
        anagram = new Anagram();
    }

    @Test
    public void areAnagrams_should_return_true_when_strings_are_anagrams() {
        String word1 = "binary";
        String word2 = "bRaIny";

        boolean result = anagram.areAnagrams(word1, word2);

        assertTrue(result);
    }


    @Test
    public void areAnagrams_should_return_false_when_strings_are_not_anagrams() {
        String word1 = "binary";
        String word2 = "br ai ny";

        boolean result = anagram.areAnagrams(word1, word2);

        assertFalse(result);
    }

    @Test
    public void areAnagrams_should_return_false_when_one_string_is_empty() {
        String word1 = "binary";
        String word2 = "";

        boolean result = anagram.areAnagrams(word1, word2);

        assertFalse(result);
    }

    @Test
    public void areAnagrams_should_return_true_when_empty_strings_are_given() {
        String word1 = "";
        String word2 = "";

        boolean result = anagram.areAnagrams(word1, word2);

        assertTrue(result);
    }

    @Test
    public void areAnagrams_should_return_false_when_nulls_are_given() {
        String word1 = null;
        String word2 = null;

        boolean result = anagram.areAnagrams(word1, word2);

        assertFalse(result);
    }

    @Test
    public void areAnagrams_should_return_false_when_first_string_is_null() {
        String word1 = null;
        String word2 = "apple";

        boolean result = anagram.areAnagrams(word1, word2);

        assertFalse(result);
    }

    @Test
    public void areAnagrams_should_return_false_when_second_string_is_null() {
        String word1 = "apple";
        String word2 = null;

        boolean result = anagram.areAnagrams(word1, word2);

        assertFalse(result);
    }


    @Test
    public void testSortString() {
        String string = "messages";
        String expected = "aeegmsss";

        String result = anagram.sortString(string);

        assertEquals(expected, result);
    }

    @Test
    public void testSortStringWithEmptyString() {
        String string = "";
        String expected = "";

        String result = anagram.sortString(string);

        assertEquals(expected, result);
    }

    @Test
    public void testSortStringWithNull() {
        String string = null;
        String expected = "";

        String result = anagram.sortString(string);

        assertEquals(expected, result);
    }

}