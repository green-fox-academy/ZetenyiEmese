import java.util.ArrayList;
import java.util.Arrays;

public class IsInList2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        ArrayList<Integer> listToFind = new ArrayList<>(Arrays.asList(4, 8, 12, 16));
        System.out.println(checkNums(list, listToFind));
    }

    public static boolean checkNums(ArrayList<Integer> list, ArrayList<Integer> listToFind){
        boolean[] itIsIn = new boolean[listToFind.size()];

        for (Integer numberToFind: listToFind) {
            itIsIn[listToFind.indexOf(numberToFind)] = list.contains(numberToFind);
        }

        boolean theListIsIn = true;
        for (boolean b: itIsIn) {
            theListIsIn = theListIsIn && b;
        }

        return  theListIsIn;
    }
}
