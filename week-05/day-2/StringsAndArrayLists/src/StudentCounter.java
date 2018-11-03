import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StudentCounter {
    public static void main(String... args){
        ArrayList<Map<String, Object>> listOfMaps = new ArrayList<Map<String, Object>>();

        // We have this (array)list of hashmaps:

        Map<String, Object> row0 = new HashMap<String, Object>(); //the first hashmap: keys are Strings, values are Objects
        row0.put("name", "Theodor");
        row0.put("age", 9.5);
        row0.put("candies", 2);
        listOfMaps.add( row0 ); //the first hashmap added to the (array)list

        Map<String, Object> row1 = new HashMap<String, Object>();
        row1.put("name", "Paul");
        row1.put("age", 10);
        row1.put("candies", 1);
        listOfMaps.add( row1 );

        Map<String, Object> row2 = new HashMap<String, Object>();
        row2.put("name", "Mark");
        row2.put("age", 7);
        row2.put("candies", 3);
        listOfMaps.add( row2 );

        Map<String, Object> row3 = new HashMap<String, Object>();
        row3.put("name", "Peter");
        row3.put("age", 12);
        row3.put("candies", 5);
        listOfMaps.add( row3 );

        Map<String, Object> row4 = new HashMap<String, Object>();
        row4.put("name", "Olaf");
        row4.put("age", 12);
        row4.put("candies", 7);
        listOfMaps.add( row4 );

        Map<String, Object> row5 = new HashMap<String, Object>();
        row5.put("name", "George");
        row5.put("age", 3);
        row5.put("candies", 2);
        listOfMaps.add( row5 );

        // Displays those people's name who have got more than 4 candies:
        System.out.print("They have got more than 4 candies: ");
        for (Map<String, Object> map: listOfMaps) {
            int numberOfCandies = (Integer)map.get("candies");
            if (numberOfCandies >= 4){
                System.out.print(map.get("name") + ", ");
            }
        }
        System.out.println();

        // Displays the sum of the ages of those people who have less than 5 candies:
        double sumOfAges = 0;
        for (Map<String, Object> map: listOfMaps) {
            int numberOfCandies = (Integer)map.get("candies");
            if (numberOfCandies < 5){
                String str = map.get("age").toString();
                sumOfAges += Double.valueOf(str);
            }
        }
        System.out.print("The sum of the age of those who have got less than 5 candies: " + sumOfAges);
    }
}
