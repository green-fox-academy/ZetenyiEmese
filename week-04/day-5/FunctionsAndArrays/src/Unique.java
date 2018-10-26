import java.util.Arrays;

public class Unique {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 11, 52, 61, 1, 34};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(unique(numbers)));
    }


    public static int[] unique(int[] array){
        int[] uniqueArray = new int[lengthOfUniqueArray(array)];
        uniqueArray[0] = array[0];
        int index = 0;

        for (int i = 1; i <= array.length-1; i++) {
            boolean isInUniqueArray = false;
            for (int j = 0; j <= uniqueArray.length-1; j++) {
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

    public static int lengthOfUniqueArray(int[] array){
        int len = array.length;
        for (int i = 0; i <= array.length-2; i++) {
            for (int j = i + 1; j <= array.length-1; j++) {
                if (array[j] == array[i]) {
                    len = len - 1;
                    System.out.println(len);
                }
            }
        }
        return len;
    }






   /* public static String unique(int[] array){
        int[] uniqArray = array;
        int item;
        // len = uniqArray.length;
        for (int i = 0; i <= uniqArray.length - 2; i++) {
            for (int j = i + 1; j <= uniqArray.length - 1; j++) {
                if (uniqArray[j] == uniqArray[i]) {
                    item = uniqArray[j];
                    uniqArray = createNewUniqueArray(uniqArray, item);
                    break;
                }
            }
        }
        return Arrays.toString(uniqArray);
    }

    public static int[] createNewUniqueArray(int[] array, int item){
        nr = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i]==item){
                nr++;
            }
        }

        int[] newUniqueArray = new int[array.length-nr+1];

        newUniqueArray[0] = array[0];

        for (int i = 1; i < array.length ; i++) {

            if (array[i] != item){
                newUniqueArray[i] = array[i];
            } else {
                newUniqueArray[i] =
            }

        }
*/

}

