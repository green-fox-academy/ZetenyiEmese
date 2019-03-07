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

  public String convertNumberToString(int input) {

    if (calculateInputLength(input) == 1) {
      String result = numberMap.get(input);
      return result;

    } else if (calculateInputLength(input) == 2) {
      String result = numberMap.get(input / 10 * 10) +
                     (input % 10 == 0 ? "" : "-" + convertNumberToString(input % 10));
      return result;

    } else if (calculateInputLength(input) == 3) {
      String result = numberMap.get(input / 100) + " hundred" +
                     (input % 100 == 0 ? "" : " and " + convertNumberToString(input % 100));
      return result;

    } else if (calculateInputLength(input) == 4) {
//      String result = numberMap.get(input / 1000) + " thousand" +
//                    (input % 1000 == 0 ? "" : " " + convertNumberToString(input % 1000));

      String result = numberMap.get(input / 1000) + " thousand" +
                      (input % 1000 == 0 ? "" :
                      ((input % 1000) / 100 == 0 ? " and " + convertNumberToString(input % 1000) : " " + convertNumberToString(input % 1000)));

      return result;
    }

    return "error";
  }

  private int calculateInputLength(int input) {
    return String.valueOf(input).length();
  }

}
