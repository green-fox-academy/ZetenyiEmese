import java.util.ArrayList;
import java.util.Arrays;

public class IsInList3 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        ArrayList<Integer> listToFind = new ArrayList<>(Arrays.asList(4, 8, 12, 16));
        System.out.println(checkNums(list, listToFind));
    }

    public static boolean checkNums(ArrayList<Integer> list, ArrayList<Integer> listToFind){
        for (Integer numberToFind: listToFind) {
            if (!list.contains(numberToFind)){
                return false;
            }
        }
        return true;
    }
}
