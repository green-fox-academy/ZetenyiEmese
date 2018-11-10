import java.util.Arrays;

public class Reverse {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj)); // [3, 4, 5, 6, 7]
        reverse(aj);
        System.out.println(Arrays.toString(aj)); // [7, 6, 5, 4, 3]
    }

    //Reverses the elements in the array so that the original array changes:
    public static void reverse(int[] array) {
        int[] arrayCopy = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++) {
            array[i] = arrayCopy[array.length - 1 - i];
        }
    }
}

