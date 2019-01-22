import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise7 {

  public static void main(String[] args) {
    //Write a Stream Expression to find the strings which starts with a given letter(as parameter), in the following list:

    List<String> cities = Arrays.asList("ROME", "LONDON", "NAIROBI", "CALIFORNIA", "ZURICH", "NEW DELHI", "AMSTERDAM", "ABU DHABI", "PARIS");

    List<String> searchedCities = findCitiesStartingWithLetter('A', cities);

    System.out.println(searchedCities);
  }

  public static List<String> findCitiesStartingWithLetter(char letter, List<String> cities) {
    return cities.stream().filter(string -> string.charAt(0) == letter).collect(Collectors.toList());
  }

}
