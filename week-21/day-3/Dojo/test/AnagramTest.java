import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class AnagramTest {

  private static Anagram anagramObj;

  @BeforeClass
  public static void init() {
    anagramObj = new Anagram();
  }

  @Test
  public void testWhenAnagram_IfLengthAreTheSame() {
    String string1 = "baba";
    String string2 = "abba";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertTrue(result);
  }

  @Test
  public void testWhenAnagram_IfStringsAreTheSame() {
    String string1 = "baba";
    String string2 = "baba";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertTrue(result);
  }

  @Test
  public void testWhenAnagram_WithIgnoringCase() {
    String string1 = "bABA";
    String string2 = "abbA";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertTrue(result);
  }

  @Test
  public void testWhenNotAnagram_IfLengthAreTheSame() {
    String string1 = "baba";
    String string2 = "mami";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

  @Test
  public void testWhenNotAnagram_IfLengthAreNotTheSame() {
    String string1 = "baba";
    String string2 = "mamamami";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

  @Test
  public void testIfOneStringIsNull() {
    String string1 = null;
    String string2 = "baba";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

  @Test
  public void testIfStringsAreBothNull() {
    String string1 = null;
    String string2 = null;

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

  @Test
  public void testIfOneStringIsEmpty() {
    String string1 = "baba";
    String string2 = "";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

  @Test
  public void testIfStringsAreBothEmpty() {
    String string1 = "";
    String string2 = "";

    boolean result = anagramObj.checkIfAreAnagrams(string1, string2);

    Assert.assertFalse(result);
  }

}
