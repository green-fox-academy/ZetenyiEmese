import java.util.ArrayList;

public class Candyshop {
    public static void main(String[] args) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        arrayList.add("Cupcake");
        arrayList.add(2);
        arrayList.add("Brownie");
        arrayList.add(false);

        System.out.println(sweets(arrayList));
    }

    public static ArrayList<Object> sweets(ArrayList<Object> list){
        for (Object item: list) {
            if(item.equals(new Integer(2))){ //Instead of new Integer(2) you can simply write 2
                list.set(list.indexOf(item), "Croissant");
            } else if (item.equals(new Boolean(false))){ //Instead of new Boolean(false) you can simply write false
                list.set(list.indexOf(item), "Ice cream");
            }
        }
        return  list;
    }
}
