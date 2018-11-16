import java.util.ArrayList;
import java.util.Arrays;

public class Unique3 {
    public static void main(String[] args) {
        int[] numbers = {1, 11, 34, 11, 34, 0, 1, 34, 0, 1, 34, 0, 52, 52, 52, 52, 10, 10};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(unique(numbers)));
    }

    //returns an array of numbers with each element occurring only once (removes all multiple elements)
    public static int[] unique(int[] array){
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < array.length ; i++) {
            list.add(array[i]);
        }

        //removes all multiple elements from the list
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).equals(list.get(i))){
                    list.remove(j);
                    j--;
                }
            }
        }

        int[] uniqueArray = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            uniqueArray[i] = list.get(i).intValue(); //converting Integer to int
        }

        return uniqueArray;
    }
}
