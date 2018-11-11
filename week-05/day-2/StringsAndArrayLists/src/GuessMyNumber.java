import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        int storedNumber = chooseNumberBetweenLimits();
        int lives = 5;
        guessTheNumber(storedNumber, lives);
    }

    public static int chooseNumberBetweenLimits(){
        System.out.println("I will choose a number between the limits you specify. Your task is to guess this number.");

        Scanner intInput = new Scanner(System.in);
        int lowerLimit;
        int higherLimit;
        boolean notOk;

        do {
            System.out.println("Enter the lower limit (an integer):");
            lowerLimit = intInput.nextInt();
            System.out.println("Enter the higher limit (an integer):");
            higherLimit = intInput.nextInt();
            notOk = lowerLimit >= higherLimit;
            if (notOk){
                System.out.println("The higher limit has to be higher than the lower limit!");
            }
        } while (notOk);

        // return a random number between lowerLimit and higherLimit
        return lowerLimit + (int)(Math.random() * (higherLimit - lowerLimit + 1));
    }

    public static void guessTheNumber(int storedNumber, int lives){
        System.out.println("Ok, I have a number. Try to guess it. You have " + lives + " lives:");

        Scanner intInput = new Scanner(System.in);
        int guessNumber;
        boolean foundIt;

        do {
            guessNumber = intInput.nextInt();
            foundIt = guessNumber == storedNumber;
            if (!foundIt) {
                lives -= 1;
                if (guessNumber > storedNumber) {
                    System.out.println("Too high. You have " + lives + " lives left.");
                } else {
                    System.out.println("Too low. You have " + lives + " lives left.");
                }
            }
        } while (!foundIt && lives >= 1);

        if (foundIt){
            System.out.println("Congratulations. You won!");
        } else {
            System.out.println("Sorry, you have no more lives :-(");
        }
    }
}
