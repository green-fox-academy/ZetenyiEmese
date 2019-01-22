import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise8 {

  public static void main(String[] args) {
    //Write a Stream Expression to concatenate a Character list to a string:

    List<Character> charList = Arrays.asList('G', 'r', 'e', 'e', 'n', 'f', 'o', 'x');

    String concatenatedCharacters = concatenate(charList);
    System.out.println(concatenatedCharacters);

    String concatenatedCharacters2 = concatenate2(charList);
    System.out.println(concatenatedCharacters2);
  }

  public static String concatenate(List<Character> charList) {
    return charList.stream().map(character -> character + "").collect(Collectors.joining(""));
  }

  public static String concatenate2(List<Character> charList) {
    return charList.stream().map(character -> character.toString()).collect(Collectors.joining(""));
  }

}
