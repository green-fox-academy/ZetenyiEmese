import java.util.HashMap;

public class CountLetters {

    public HashMap<Character, Integer> countLetters(String string) {
        HashMap<Character, Integer> dictionary = new HashMap<>(); //empty hashmap

        if (string == null) return dictionary;

        char[] letters = string.toCharArray();

        for (char letter : letters) {
            if (dictionary.containsKey(letter)) {
                dictionary.put(letter, dictionary.get(letter) + 1);
            } else {
                dictionary.put(letter, 1);
            }
        }

        return dictionary;
    }

}
