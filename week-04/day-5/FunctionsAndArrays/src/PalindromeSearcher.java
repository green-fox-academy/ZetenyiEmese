import java.util.ArrayList;
import java.util.Scanner;

public class PalindromeSearcher {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        System.out.println("Give me a string to search for palindromes in it:");
        String text = textInput.nextLine();

        System.out.println(searchPalindrome(text));
    }

    public static ArrayList<String> searchPalindrome(String text){
        //System.out.println("racecar".substring("racecar".length()-3, "racecar".length())); -> car
        ArrayList<String> palindromes = new ArrayList<String>();

        for (int i = 0; i <= text.length()-3; i++) {
            for (int j = i + 3; j <= text.length(); j++) {
                String subString = text.substring(i, j);
                if (palindrome(subString)){
                    palindromes.add(subString);
                }
            }
        }
        return palindromes;
    }

    public static boolean palindrome(String string){
        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}