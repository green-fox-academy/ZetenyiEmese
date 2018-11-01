import java.util.ArrayList;
import java.util.Arrays;

public class SolarSystem {
    public static void main(String[] args) {
        ArrayList<String> planetList = new ArrayList<String>();
        planetList.addAll(Arrays.asList("Mercury","Venus","Earth","Mars","Jupiter","Uranus","Neptune"));
        System.out.println(putSaturn(planetList));
        System.out.println(planetList); //the original arraylist planetList is changed
    }

    public static ArrayList<String> putSaturn(ArrayList<String> list){
        list.add(5, "Saturn");
        return list;
    }
}
