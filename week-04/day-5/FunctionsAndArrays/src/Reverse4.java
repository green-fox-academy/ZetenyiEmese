import java.util.Arrays;

public class Reverse4 {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj)); // [3, 4, 5, 6, 7]
        reverse(aj);
        System.out.println(Arrays.toString(aj)); // [7, 6, 5, 4, 3]
    }

    //Reverses the elements in the array so that the original array changes:
    public static void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int item = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = item;
        }
    }
}
