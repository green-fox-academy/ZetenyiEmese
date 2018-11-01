import java.util.Arrays;

public class Unique2 {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 11, 34, 0, 1, 34, 0, 1, 34, 0, 52, 52, 52, 52, 10, 10};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(unique(numbers)));
    }

    //returns an array of numbers with each element occurring only once (removes all multiple elements)
    public static int[] unique(int[] array){
        int[] uniqueArray = new int[array.length]; //an array filled with zeros the same size as the original array
        int index = 0;

        for (int i = 0; i < array.length; i++) {
            boolean isInUniqueArray = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == uniqueArray[j]){//checks if the element is already in unique array
                    isInUniqueArray = true;
                    break;
                }
            }

            if (!isInUniqueArray){
                uniqueArray[index] = array[i]; //puts the element into unique array if it wasn't found
                index++;
            }
        }
        return Arrays.copyOf(uniqueArray, index); //creates a copy of the filled part
    }

}
