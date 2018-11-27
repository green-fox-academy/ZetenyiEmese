public class String2 {

    public static void main(String[] args) {
        // Given a string, compute recursively a new string where all the 'x' chars have been removed.

        String text = "alxMaxaT aXahnxssxXx";
        System.out.println(text);
        System.out.println(removeAllX(new StringBuilder(text)));
        System.out.println(removeAllX2(text));
    }

    public static String removeAllX(StringBuilder text){
        if (text.toString().contains("x")){
            int i = text.toString().indexOf('x');
            text.deleteCharAt(i);
            return removeAllX(text);
        }

        return text.toString();
    }

    public static String removeAllX2(String text){
        StringBuilder newText = new StringBuilder(text);
        if (text.contains("x")){
            int i = text.indexOf('x');
            newText.deleteCharAt(i);
            return removeAllX2(newText.toString());
        }

        return newText.toString();
    }
}
