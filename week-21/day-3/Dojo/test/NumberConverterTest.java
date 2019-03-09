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
  public void convertAmountInNumbersToWords_shouldReturnSevenWhen7String() {
    String input = "7.00 $";
    String expected = "seven dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnTwentythreeWhen23String() {
    String input = "23.00 $";
    String expected = "twenty-three dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen40String() {
    String input = "40.00 $";
    String expected = "forty dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnNinetynineWhen99String() {
    String input = "99.00 $";
    String expected = "ninety-nine dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen125String() {
    String input = "125.00 $";
    String expected = "one hundred and twenty-five dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen105String() {
    String input = "105.00 $";
    String expected = "one hundred and five dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen200String() {
    String input = "200.00 $";
    String expected = "two hundred dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen380String() {
    String input = "380.00 $";
    String expected = "three hundred and eighty dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen768String() {
    String input = "768.00 $";
    String expected = "seven hundred and sixty-eight dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen3584String() {
    String input = "3584.00 $";
    String expected = "three thousand five hundred and eighty-four dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen1000String() {
    String input = "1000.00 $";
    String expected = "one thousand dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen7804String() {
    String input = "7804.00 $";
    String expected = "seven thousand eight hundred and four dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }


  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen6900String() {
    String input = "6900.00 $";
    String expected = "six thousand nine hundred dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen2007String() {
    String input = "2007.00 $";
    String expected = "two thousand and seven dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen6080String() {
    String inputString = "6080.00 $";
    String expected = "six thousand and eighty dollars";

    String result = numberConverter.convertAmountInNumbersToWords(inputString);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen56381String() {
    String input = "56381.00 $";
    String expected = "fifty-six thousand three hundred and eighty-one dollars";

    String result = numberConverter.convertAmountInNumbersToWords(input);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen100000String() {
    String inputString = "100000.00 $";
    String expected = "one hundred thousand dollars";

    String result = numberConverter.convertAmountInNumbersToWords(inputString);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen456080String() {
    String inputString = "456080.00 $";
    String expected = "four hundred and fifty-six thousand and eighty dollars";

    String result = numberConverter.convertAmountInNumbersToWords(inputString);

    assertEquals(expected, result);
  }

  @Test
  public void convertAmountInNumbersToWords_shouldReturnCorrectAnswerWhen803044String() {
    String inputString = "803044.00 $";
    String expected = "eight hundred and three thousand and forty-four dollars";

    String result = numberConverter.convertAmountInNumbersToWords(inputString);

    assertEquals(expected, result);
  }

}
