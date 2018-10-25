import java.util.Arrays;

public class SumAll {
    public static void main(String[] args) {
        int[] ai = {3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(ai));
        System.out.println("The sum of the elements: " + sumAll(ai));
    }

    public static int sumAll(int[] array){
        int sum = 0;
        for (int x: array) {
            sum += x;
        }
        return sum;
    }

}
