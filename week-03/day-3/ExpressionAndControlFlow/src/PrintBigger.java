import java.util.Scanner;
public class PrintBigger {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter two integers:");
        int number1 = intInput.nextInt();
        int number2 = intInput.nextInt();

        if (number1 > number2) {
            System.out.println("The bigger is: " + number1);
        } else if (number2 > number1) {
            System.out.println("The bigger is: " + number2);
        } else {
            System.out.println("They are equal");
        }
    }
}
