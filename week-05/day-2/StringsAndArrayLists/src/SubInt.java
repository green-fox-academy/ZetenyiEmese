import java.util.ArrayList;

public class SubInt {
    public static void main(String[] args) {
        int[] integers = {1, 11, 34, 52, 61, 5346};

        System.out.println(subInt(1, integers)); // should print: `[0, 1, 4]`
        System.out.println(subInt(9, integers)); // should print: '[]'
        System.out.println(subInt(34, integers)); // should print: '[2, 5]'
    }

    public static ArrayList<Integer> subInt(int number, int[] intArray){
        //This doesn' work:
        //ArrayList<Integer> intList = new ArrayList<Integer>(Arrays.asList(intArray));
        //System.out.println(intList);

        ArrayList<Integer> indices = new ArrayList<Integer>();

        for (int i = 0; i < intArray.length; i++) {
            if (isItIn(number, intArray[i])){
                indices.add(i);
            }
        }
        return indices;
    }

    public static boolean isItIn(int findMeNr, int serchMeNr){
        //String findMeString = new String(findMeNr); this doesn't work

        String findMeString = ((Integer)findMeNr).toString(); //converting int to String
        String searchMeString = ((Integer)serchMeNr).toString(); //converting int to String

        if (searchMeString.indexOf(findMeString) >= 0){
            return true; //the searched number is found
        }
        return false; //the searched number is not found
    }
}
