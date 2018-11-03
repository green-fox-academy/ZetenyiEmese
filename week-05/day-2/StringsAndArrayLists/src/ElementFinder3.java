import java.util.ArrayList;
import java.util.Arrays;

public class ElementFinder3 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(containsSeven(arrayList));
    }

    public static String containsSeven(ArrayList<Integer> list){
        if (list.contains(new Integer(7))) { //Instead of new Integer(7) you can simply write 7
            return "Hoorray!";
        } else {
            return "Noooooo!";
        }
    }
}
