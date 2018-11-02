import java.util.ArrayList;
import java.util.Arrays;

public class QuoteSwap {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.addAll(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));
        System.out.println(quoteSwap(list));

        // Expected output: "What I cannot create I do not understand."
    }

    public static String quoteSwap(ArrayList<String> list){
        list.set(list.indexOf("I") + 1, "cannot");
        list.set(list.lastIndexOf("I") + 1, "do");
        //System.out.println(list);

        String quote = "";
        for (String word: list) {
            quote += word + " ";
        }

        return  quote;
    }
}
