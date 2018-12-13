import java.util.Arrays;

public class Anagram {

    public boolean areAnagrams(String word1, String word2) {
        if (word1 == null || word2 == null) return false;
        if (word1.length() != word2.length()) return false;

        return sortString(word1).equals(sortString(word2));
    }

    public String sortString(String string) {
        if (string == null) return "";
        char[] chars = string.toLowerCase().toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

}
