public class Reverse {
    public static void main(String[] args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reversed);
        System.out.println(reverse(reversed));
        System.out.println(reversed); //string reversed is not changed
    }

    public static String reverse(String text){
        String newText = "";

        for (int i = text.length()-1; i >= 0 ; i--) {
            newText += text.charAt(i);
        }

        return newText;
    }
}
