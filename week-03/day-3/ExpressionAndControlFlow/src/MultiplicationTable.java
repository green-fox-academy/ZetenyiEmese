import java.util.Scanner;
public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter a number (integer):");
        int number = intInput.nextInt();

        for (int i=0; i<10; i++) {
            System.out.println((i+1) + " * " + number + " = " + ((i+1)*number));
        }
    }
}
