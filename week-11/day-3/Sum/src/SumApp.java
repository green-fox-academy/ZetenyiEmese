import java.util.ArrayList;

public class SumApp {

    public int sum(ArrayList<Integer> numbers) {
        if (numbers == null) return 0;
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        return sum;
    }

}
