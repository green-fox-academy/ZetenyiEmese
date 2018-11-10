import java.util.Arrays;

public class Bubble {
    public static void main(String[] args) {
        int[] elements = {34, 12, 24, 9, 5, 102, 0, -45, -8};
        System.out.println(Arrays.toString(bubble(elements)));
        System.out.println(Arrays.toString(advancedBubble(elements, true)));
    }

    //sort the elements of the array in ascending order
    public static int[] bubble(int[] intArray){
        for (int i = 0; i <= intArray.length - 2; i++) {
            int minIndex = i;
            for (int j = i + 1; j <= intArray.length - 1; j++) {
                if(intArray[j] < intArray[minIndex]){
                        minIndex = j;
                }
            }
            if (minIndex != i){
                int item = intArray[i];
                intArray[i] = intArray[minIndex];
                intArray[minIndex] = item;
            }
        }
        return intArray;
    }

    //sort the elements of the array in descending order if b = true, else sort it in ascending order
    public static int[] advancedBubble(int[] intArray, boolean b){
        if (!b){
            return bubble(intArray);
        } else {
            for (int i = 0; i <= intArray.length - 2; i++) {
                int maxIndex = i;
                for (int j = i + 1; j <= intArray.length - 1; j++) {
                    if(intArray[j] > intArray[maxIndex]){
                        maxIndex = j;
                    }
                }
                if (maxIndex != i){
                    int item = intArray[i];
                    intArray[i] = intArray[maxIndex];
                    intArray[maxIndex] = item;
                }
            }
            return intArray;
        }
    }
}