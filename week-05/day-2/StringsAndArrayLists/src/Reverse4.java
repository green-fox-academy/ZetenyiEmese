public class Reverse4 {
    public static void main(String[] args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        System.out.println(reversed);
        System.out.println(reverse(reversed));
        System.out.println(reversed); //string reversed is not changed
    }

    public static String reverse(String text){
        char[] charArray = text.toCharArray();
        //System.out.println(charArray);

        for (int i = 0, j = charArray.length-1; i < j; i++, j--) {
            char c = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = c;
        }

        return new String(charArray);
    }
}
