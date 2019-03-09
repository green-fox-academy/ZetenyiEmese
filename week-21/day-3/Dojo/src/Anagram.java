import java.util.ArrayList;

public class Anagram {

  public boolean checkIfAreAnagrams(String string1, String string2) {
    if (string1 == null || string2 == null) return false;
    if (string1.isEmpty() || string2.isEmpty()) return false;
    if (string1.length() != string2.length()) return false;

    ArrayList<Character> string1AsArrayList = stringToArrayList(string1);
    ArrayList<Character> string2AsArrayList = stringToArrayList(string2);

    return string1AsArrayList.containsAll(string2AsArrayList) && string2AsArrayList.containsAll(string1AsArrayList);
  }

  private ArrayList<Character> stringToArrayList(String string) {
    ArrayList<Character> list = new ArrayList<>();

    for (int i = 0; i < string.length(); i++) {
      list.add(string.toLowerCase().charAt(i));
    }
    return list;
  }

}
