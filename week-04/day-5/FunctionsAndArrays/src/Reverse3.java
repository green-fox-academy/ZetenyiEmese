import java.util.Arrays;

public class Reverse3 {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj));
        reverse(aj);
        System.out.println(Arrays.toString(aj));
    }

    //Reverses the elements in the array so that the original array changes:
    public static void reverse(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int item = array[i];
            array[i] = array[j];
            array[j] = item;
        }
    }
}
