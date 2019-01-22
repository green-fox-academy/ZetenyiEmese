import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {

  public static void main(String[] args) {
    //Write a Stream Expression to find the uppercase characters in a string:

    String string = "Harry Potter";
    List<Character> charList = createCharList(string);

    List<Character> uppercaseCharacters = charList.stream().filter(c -> Character.isUpperCase(c)).collect(Collectors.toList());
    System.out.println(uppercaseCharacters);

    List<Character> uppercaseCharacters2 = charList.stream().filter(Character::isUpperCase).collect(Collectors.toList());
    System.out.println(uppercaseCharacters2);
  }

  public static List<Character> createCharList(String text) {
    List<Character> characterList = new ArrayList<>();
    for (char c : text.toCharArray()) {
      characterList.add(c);
    }
    return characterList;
  }

}
