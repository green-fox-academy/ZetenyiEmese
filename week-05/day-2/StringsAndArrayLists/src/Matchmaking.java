import java.util.ArrayList;
import java.util.Arrays;

public class Matchmaking {
    public static void main(String[] args) {
        ArrayList<String> girls = new ArrayList<String>(Arrays.asList("Eve","Ashley","Claire","Kat","Jane"));
        ArrayList<String> boys = new ArrayList<String>(Arrays.asList("Joe","Fred","Tom","Todd","Neef","Jeff"));

        System.out.println(makingMatches(girls, boys));
    }

    public static ArrayList<String> makingMatches(ArrayList<String> girls, ArrayList<String> boys ){
        ArrayList<String> newList = new ArrayList<String>();
        for (int i = 0; i < girls.size() && i < boys.size(); i++) {
            newList.add(girls.get(i));
            newList.add(boys.get(i));
        }
        return newList;
    }
}

