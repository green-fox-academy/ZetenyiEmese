import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner textInput = new Scanner(System.in);
        System.out.println("Give me two strings to test if they are anagrams: ");

        System.out.println("The first: ");
        String text1 = textInput.nextLine();

        System.out.println("The second: ");
        String text2 = textInput.nextLine();

        if (anagram(text1, text2)){
            System.out.println("They are anagrams.");
        } else {
            System.out.println("They are not anagrams.");
        }

    }

    public static boolean anagram(String string1, String string2) {
            char[] charArray1 = createCharacterArray(string1);
            char[] charArray2 = createCharacterArray(string2);
            return equals(charArray1, charArray2);
    }

    public static char[] createCharacterArray(String string){
        char[] charArray = new char[string.length()];
        for (int i = 0; i < string.length(); i++) {
            charArray[i] = string.toLowerCase().charAt(i);
        }
        return charArray;
    }

    public static boolean equals(char[] array1, char[] array2){
        char[] sortedArray1 = sort(array1);
        char[] sortedArray2 = sort(array2);

        if (sortedArray1.length != sortedArray2.length){
            return false;
        } else {
            for (int i = 0; i < sortedArray1.length; i++) {
                if (sortedArray1[i] != sortedArray2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static char[] sort(char[] array){
        for (int i = 0; i <= array.length-2 ; i++) {
            int min = i;
            for (int j = i + 1; j <= array.length-1; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min > i) {
                char c = array[i];
                array[i] = array[min];
                array[min] = c;
            }
        }
        //System.out.println(Arrays.toString(array));
        return array;
    }
}
