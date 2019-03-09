import java.util.HashMap;

public class NumberConverter {

  private HashMap<Integer, String> numberMap;

  public NumberConverter() {
    this.numberMap = new HashMap<>();
    numberMap.put(0, "");
    numberMap.put(1, "one");
    numberMap.put(2, "two");
    numberMap.put(3, "three");
    numberMap.put(4, "four");
    numberMap.put(5, "five");
    numberMap.put(6, "six");
    numberMap.put(7, "seven");
    numberMap.put(8, "eight");
    numberMap.put(9, "nine");
    numberMap.put(10, "ten");
    numberMap.put(11, "eleven");
    numberMap.put(12, "tvelve");
    numberMap.put(13, "thirteen");
    numberMap.put(14, "fourteen");
    numberMap.put(15, "fifteen");
    numberMap.put(16, "sixteen");
    numberMap.put(17, "seventeen");
    numberMap.put(18, "eighteen");
    numberMap.put(19, "nineteen");
    numberMap.put(20, "twenty");
    numberMap.put(30, "thirty");
    numberMap.put(40, "forty");
    numberMap.put(50, "fifty");
    numberMap.put(60, "sixty");
    numberMap.put(70, "seventy");
    numberMap.put(80, "eighty");
    numberMap.put(90, "ninety");
    numberMap.put(100, "hundred");
    numberMap.put(1000, "thousand");
    numberMap.put(1000000, "million");
  }

  public String convertAmountInNumbersToWords(String inputString) {
    try {
      int inputNumber = convertStringToNumber(inputString);
      String result = convertNumberToString(inputNumber) + " dollars";
      //    System.out.println(result);
      return result;

    } catch (NumberFormatException ex) {
      System.out.println("Can't convert the amount to a number!");
      return "";

    } catch (Exception ex) {
      System.out.println("Something went wrong!");
      return "";
    }
  }

  private String convertNumberToString(int input) {
    int mod;

    if (calculateInputLength(input) == 1) {
      String result = numberMap.get(input);
      return result;

    } else if (calculateInputLength(input) == 2) {
      mod = input % 10;
      String result = numberMap.get(input / 10 * 10) +
              (mod == 0 ? "" : "-" + convertNumberToString(mod));
      return result;

    } else if (calculateInputLength(input) == 3) {
      mod = input % 100;
      String result = numberMap.get(input / 100) + " hundred" +
              (mod == 0 ? "" : " and " + convertNumberToString(mod));
      return result;

    } else if (calculateInputLength(input) <= 6) {
      mod = input % 1000;
      String result = convertNumberToString(input / 1000) + " thousand" +
              (mod == 0 ? "" : (mod / 100 == 0 ? " and " + convertNumberToString(mod) : " " + convertNumberToString(mod)));
      return result;
    }

    return "error";
  }

  private int convertStringToNumber(String string) throws NumberFormatException, Exception {
//    int length = string.length();
//    return Integer.parseInt(string.substring(0, length - 5));
    int indexOfDot = string.indexOf('.');
    String numberString = string.substring(0, indexOfDot);
    return Integer.parseInt(numberString);
  }

  private int calculateInputLength(int input) {
    return String.valueOf(input).length();
  }

}
