public class Gnirts implements CharSequence {

    private String text;

    public Gnirts(String text) {
        this.text = text;
    }

    @Override
    public int length() {
        char[] chars = text.toCharArray();
        return chars.length;
    }

    @Override
    public char charAt(int index) {
        char[] chars = text.toCharArray();

        try {
            return chars[chars.length - 1 - index];
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return 0;
    }

    @Override
    public String subSequence(int start, int end) {
        String subString = "";
        char[] chars = text.toCharArray();

        try {
            for (int i = start; i < end; i++) {
                subString += chars[chars.length - 1 - i];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }

        return subString;
    }

}
