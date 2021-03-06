import java.util.ArrayList;
import java.util.Arrays;

public class ElementFinder2 {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        System.out.println(containsSeven(arrayList));
    }

    public static String containsSeven(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(new Integer(7))) { //Instead of new Integer(7) you can simply write 7
                return "Hoorray!";
            }
        }
        return "Noooooo!";
    }
}
