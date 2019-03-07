import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;

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
  public void convertNumberToString_shouldReturnSevenWhen7() {
    int input = 7;
    String expected = "seven";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnTwentythreeWhen23() {
    int input = 23;
    String expected = "twenty-three";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnNinetynineWhen99() {
    int input = 99;
    String expected = "ninety-nine";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen40() {
    int input = 40;
    String expected = "forty";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen125() {
    int input = 125;
    String expected = "one hundred and twenty-five";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen768() {
    int input = 768;
    String expected = "seven hundred and sixty-eight";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen105() {
    int input = 105;
    String expected = "one hundred and five";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen200() {
    int input = 200;
    String expected = "two hundred";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen380() {
    int input = 380;
    String expected = "three hundred and eighty";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen3584() {
    int input = 3584;
    String expected = "three thousand five hundred and eighty-four";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen1000() {
    int input = 1000;
    String expected = "one thousand";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen7804() {
    int input = 7804;
    String expected = "seven thousand eight hundred and four";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen5030() {
    int input = 5030;
    String expected = "five thousand and thirty";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen6900() {
    int input = 6900;
    String expected = "six thousand nine hundred";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertNumberToString_shouldReturnCorrectAnswerWhen2007() {
    int input = 2007;
    String expected = "two thousand and seven";

    String result = numberConverter.convertNumberToString(input);

    assertEquals(expected, result);
  }

}
