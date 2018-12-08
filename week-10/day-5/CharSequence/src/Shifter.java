public class Shifter implements CharSequence {

    private String text;
    private int shift;

    public Shifter(String text, int shift) {
        this.text = text;
        this.shift = shift;
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
            return chars[index + shift];
        } catch (ArrayIndexOutOfBoundsException ex) {

        }

        return 0;
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        String string = "";
        char[] chars = text.toCharArray();

        try {
            for (int i = start; i < end; i++) {
                string += chars[i + shift];
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return null;
        }

        return string;
    }

}
