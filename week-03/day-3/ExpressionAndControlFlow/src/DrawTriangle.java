import java.util.Scanner;
public class DrawTriangle {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter a number (integer):");
        int number = intInput.nextInt();

        String stars = "";
        for (int i = 0; i < number; i++) {
            stars = stars + "*";
            System.out.println(stars);
        }
    }
}
