import java.util.Scanner;

public class PalindromeBuilder {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        System.out.println("Give me a string to create a palindrome from it:");
        String text = textInput.nextLine();

        System.out.println(createPalindrome(text));
    }

    public static String createPalindrome(String text){
        return text + reverse(text);
    }

    public static String reverse(String string){
        char[] charArray = string.toCharArray();

        for (int i = 0, j = charArray.length - 1; i < j ; i++, j--) {
            char c = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = c;
        }
        return new String(charArray);
    }
}