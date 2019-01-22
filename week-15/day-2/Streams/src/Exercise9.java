import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise9 {

  public static void main(String[] args) {
    //Write a Stream Expression to find the frequency of characters in a given string!

    String string = "GreenfoxGreenfox";

    System.out.println(createCharList(string).stream().collect(Collectors.groupingBy((Character -> Character), Collectors.counting())));
  }

  public static List<Character> createCharList(String text) {
    List<Character> characterList = new ArrayList<>();
    for (int i = 0; i < text.length(); i++) {
      characterList.add(text.charAt(i));
    }
    return characterList;
  }

}
