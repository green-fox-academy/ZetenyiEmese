import java.util.Arrays;

public class Reverse2 {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(aj));
        System.out.println(Arrays.toString(createsAReversedArray(aj)));
        System.out.println(Arrays.toString(aj));
    }

    // Creates a new array with the reversed elements, but the original array remains the same:
    public static int[] createsAReversedArray(int[] array){
        int[] reverseArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reverseArray[i] = array[array.length-1-i];
        }
        return reverseArray;
    }
}
