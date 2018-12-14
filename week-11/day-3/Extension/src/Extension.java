import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by aze on 2017.04.04..
 */
public class Extension {

    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
        return max(max(a, b), c);
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int median(List<Integer> pool) {
        if (pool == null || pool.size() == 0) return 0;
        return pool.get((pool.size()-1)/2);
    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'u', 'o', 'e', 'i').contains(c);
    }

    String translate(String hungarian) {
        if (hungarian == null) return "";

        StringBuilder teve = new StringBuilder(hungarian);

        for (int i = 0; i < teve.length(); i++) {
            char c = teve.charAt(i);
            if (isVowel(c)) {
                teve.replace(i, i + 1, c + "v" + c);
                i += 2;
            }
        }

        return teve.toString();
    }

}