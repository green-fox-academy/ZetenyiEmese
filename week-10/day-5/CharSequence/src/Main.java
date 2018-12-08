public class Main {

    public static void main(String[] args) {
        Gnirts gnirts = new Gnirts("example");

        System.out.println(gnirts.length());
        System.out.println(gnirts.charAt(5));
        System.out.println(gnirts.subSequence(2, 6));

        Shifter shifter = new Shifter("example", 2);

        System.out.println(shifter.length());
        System.out.println(shifter.charAt(2));
        System.out.println(shifter.subSequence(1, 5));
    }

}
