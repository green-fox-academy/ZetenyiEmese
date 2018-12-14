import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ExtensionTest {

    private Extension extension = new Extension();

    @Test
    public void testAdd_2and3is5() {
        assertEquals(5, extension.add(2, 3));
    }

    @Test
    public void testAdd_1and4is5() {
        assertEquals(5, extension.add(1, 4));
    }

    @Test
    public void testAdd_3and4is7() {
        assertEquals(7, extension.add(3, 4));
    }

    @Test
    public void testMaxOfThree_first() {
        assertEquals(5, extension.maxOfThree(5, 4, 3));
    }

    @Test
    public void testMaxOfThree_second() {
        assertEquals(5, extension.maxOfThree(3, 5, 4));
    }

    @Test
    public void testMaxOfThree_third() {
        assertEquals(5, extension.maxOfThree(3, 4, 5));
    }

    @Test
    public void testMedian_one() {
        assertEquals(5, extension.median(Arrays.asList(5)));
    }

    @Test
    public void testMedian_two() {
        assertEquals(7, extension.median(Arrays.asList(7,  8)));
    }

    @Test
    public void testMedian_four() {
        assertEquals(2, extension.median(Arrays.asList(1,2,3,4)));
    }

    @Test
    public void testMedian_five() {
        assertEquals(3, extension.median(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    public void testMedian_empty() {
        assertEquals(0, extension.median(Arrays.asList()));
    }

    @Test
    public void testMedian_null() {
        assertEquals(0, extension.median(null));
    }

    @Test
    public void testIsVowel_a() {
        assertTrue(extension.isVowel('a'));
    }

    @Test
    public void testIsVowel_u() {
        assertTrue(extension.isVowel('u'));
    }

    @Test
    public void testTranslate_bemutatkozik() {
        assertEquals("bevemuvutavatkovozivik", extension.translate("bemutatkozik"));
    }

    @Test
    public void testTranslate_lagopus() {
        assertEquals("lavagovopuvus", extension.translate("lagopus"));
    }

    @Test
    public void testTranslate_alma() {
        assertEquals("avalmava", extension.translate("alma"));
    }

    @Test
    public void testTranslate_akar() {
        assertEquals("avakavar", extension.translate("akar"));
    }

    @Test
    public void testTranslate_a() {
        assertEquals("ava", extension.translate("a"));
    }

    @Test
    public void testTranslate_aa() {
        assertEquals("avaava", extension.translate("aa"));
    }

    @Test
    public void testTranslate_aaaa() {
        assertEquals("avaavaavaava", extension.translate("aaaa"));
    }

}