public class Reverse3 {
    public static void main(String[] args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reversed);
        System.out.println(reverse(reversed));
    }

    public static String reverse(String text){
        StringBuilder newText = new StringBuilder(text);
        newText.reverse();
        return newText.toString();
    }
}
