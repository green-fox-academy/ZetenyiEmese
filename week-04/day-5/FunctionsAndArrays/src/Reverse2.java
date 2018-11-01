import java.util.Arrays;

public class Reverse2 {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj));
        System.out.println(Arrays.toString(reverseArray(aj)));
        System.out.println(Arrays.toString(aj)); //the original array is not changed
    }

    // Creates a new array with the reversed elements, but the original array remains the same:
    public static int[] reverseArray(int[] array){
        int[] revArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            revArray[i] = array[array.length-1-i];
        }
        return revArray;
    }
}
