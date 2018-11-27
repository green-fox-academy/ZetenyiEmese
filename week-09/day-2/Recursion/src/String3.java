public class String3 {

    public static void main(String[] args) {
        // Given a string, compute recursively a new string where all the
        // adjacent chars are now separated by a "*".

        String text = "Greenfox";
        System.out.println(text); // Greenfox
        System.out.println(separateCharsByStar(text)); // G*r*e*e*n*f*o*x
    }

    public static String separateCharsByStar(String text) {
        if (text.length() > 1) {
            return text.charAt(0) + "*" + separateCharsByStar(text.substring(1));
        }

        return text;
    }
}
