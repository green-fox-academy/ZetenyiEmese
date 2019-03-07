import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NumberConverterTest {

  private static NumberConverter numberConverter;

  @BeforeClass
  public static void init() {
    numberConverter = new NumberConverter();
  }

  @Test
  public void checkIfObjectExists() {
    assertNotNull(numberConverter);
  }

  @Test
  public void numberToString_shouldReturnSevenWhen7() {
    int input = 7;
    String expected = "seven";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnEightWhen8() {
    int input = 8;
    String expected = "eight";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnTwentythreeWhen23() {
    int input = 23;
    String expected = "twenty-three";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnNinetynineWhen99() {
    int input = 99;
    String expected = "ninety-nine";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen768() {
    int input = 768;
    String expected = "seven hundred and sixty-eight";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen125() {
    int input = 125;
    String expected = "one hundred and twenty-five";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen105() {
    int input = 105;
    String expected = "one hundred and five";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen3584() {
    int input = 3584;
    String expected = "three thousand five hundred and eighty-four";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen1000() {
    int input = 1000;
    String expected = "one thousand";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen200() {
    int input = 200;
    String expected = "two hundred";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen205() {
    int input = 205;
    String expected = "two hundred and five";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void numberToString_shouldReturnCorrectAnswerWhen40() {
    int input = 40;
    String expected = "forty";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }


}
