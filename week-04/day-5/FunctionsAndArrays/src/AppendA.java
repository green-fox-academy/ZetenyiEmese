import java.util.Arrays;

public class AppendA {
    public static void main(String[] args) {
        String[] animals = {"koal", "pand", "zebr"};
        appendA(animals);
        System.out.println(Arrays.toString(animals));
    }

    public static void appendA(String[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] += "a";
        }
    }
}
