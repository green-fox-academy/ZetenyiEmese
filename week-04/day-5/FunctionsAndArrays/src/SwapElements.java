import java.util.Arrays;

public class SwapElements {
    public static void main(String[] args) {
        String[] abc = {"first", "second", "third"};
        System.out.println(Arrays.toString(abc));
        swapFirstWithThird(abc);
        System.out.println(Arrays.toString(abc));
    }

    public static void swapFirstWithThird(String[] array){
        String str = array[0];
        array[0] = array[2];
        array[2] = str;
    }
}
