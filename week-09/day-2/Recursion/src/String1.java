public class String1 {

    public static void main(String[] args) {
        // Given a string, compute recursively (no loops) a new string where all the
        // lowercase 'x' chars have been changed to 'y' chars.
        
        String text = "alxmaxataXahnxssxXx";
        System.out.println(text);
        System.out.println(replaceXwithY(new StringBuilder(text)));
        System.out.println(replaceXwithY2(text));
    }

    public static String replaceXwithY(StringBuilder text){
        if (text.toString().contains("x")){
            int i = text.toString().indexOf('x');
            text.setCharAt(i, 'y');
            return replaceXwithY(text);
        }

        return text.toString();
    }

    public static String replaceXwithY2(String text){
        StringBuilder newText = new StringBuilder(text);
        if (text.contains("x")){
            int i = text.indexOf('x');
            newText.setCharAt(i, 'y');
            return replaceXwithY2(newText.toString());
        }

        return newText.toString();
    }
}
