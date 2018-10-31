public class TakesLonger {
    public static void main(String[] args) {
        String quote = "Hofstadter's Law: It you expect, even when you take into account Hofstadter's Law.";
        quote = fixError(quote);
        System.out.println(quote);
    }

    public static String fixError(String string){
        int i = string.indexOf("you");
        String str1 = string.substring(0, i-1);
        String str2 = string.substring(i);

        return str1 + " always takes longer than " + str2;
    }
}
