import java.util.Scanner;
public class DrawPyramid {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter a number (integer):");
        int number = intInput.nextInt();

        String stars = "*";
        String spaces = "";
        String oneLine;

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number-i-1; j++) {
                spaces = spaces + " ";
            }
            oneLine =  spaces + stars + spaces;
            System.out.println(oneLine);
            stars = stars + "**";
            spaces = "";
        }
    }
}
