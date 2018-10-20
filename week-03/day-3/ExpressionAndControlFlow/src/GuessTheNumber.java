import java.util.Scanner;
public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        int storedNumber = 12;
        System.out.println("Try to guess the number:");
        int guessNumber = intInput.nextInt();

        while (storedNumber != guessNumber) {
            if (storedNumber > guessNumber) {
                System.out.println("The stored number is higher");
            } else {
                System.out.println("The stored number is lower");
            }
            guessNumber = intInput.nextInt();
        }
        System.out.println("You have found the number: " + storedNumber);
    }
}
