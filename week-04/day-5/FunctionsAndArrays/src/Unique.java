import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 11, 52, 61, 1, 34};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(unique(numbers)));
    }

    //returns an array of numbers without duplicates
    public static int[] unique(int[] array){
        int[] uniqueArray = new int[lengthOfUniqueArray(array)];
        uniqueArray[0] = array[0];
        int index = 0;

        for (int i = 1; i <= array.length-1; i++) {
            boolean isInUniqueArray = false;
            for (int j = 0; j <= index; j++) {
                if (array[i] == uniqueArray[j]){
                    isInUniqueArray = true;
                    break;
                }
            }
            
            if (!isInUniqueArray){
                index++;
                uniqueArray[index] = array[i];
            }
        }
        return uniqueArray;
    }

    //finds the length of the unique array without duplicates
    public static int lengthOfUniqueArray(int[] array){
        int len = array.length;
        for (int i = 0; i <= array.length-2; i++) {
            for (int j = i + 1; j <= array.length-1; j++) {
                if (array[j] == array[i]) {
                    len--;
                }
            }
        }
        return len;
    }

}

