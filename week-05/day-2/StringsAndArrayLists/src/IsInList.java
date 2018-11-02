import java.util.ArrayList;
import java.util.Arrays;

public class IsInList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        System.out.println(checkNums(list));
    }

    public static boolean checkNums(ArrayList<Integer> list){
        if (list.containsAll(Arrays.asList(4, 8, 12, 16))) {
            return true;
        } else {
            return false;
        }
    }
}
