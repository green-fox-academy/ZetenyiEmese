import java.util.Scanner;
public class GuessANumberBetweenRanges {
    public static void main(String[] args){

        Scanner intInput = new Scanner(System.in);
        int lowerRange;
        int higherRange;
        boolean notOk;
        int lives = 5;

        System.out.println("Give me the ranges where the number to be guessed should be:");

        do {
            System.out.println("Enter the lower range (an integer):");
            lowerRange = intInput.nextInt();
            System.out.println("Enter the higher range (an integer):");
            higherRange = intInput.nextInt();
            notOk = lowerRange >= higherRange;
            if (notOk){
                System.out.println("The higher range has to be higher than the lower range!");
            }
        } while (notOk);

        int storedNumber = lowerRange + (int)(Math.random() * ((higherRange - lowerRange) + 1));
        //System.out.println(storedNumber);
        System.out.println("Ok. I have a number between " + lowerRange + " - " + higherRange + ".");
        System.out.println("Try to guess it. You have " + lives + " lives:");

        int guessNumber;
        boolean foundIt;
        do {
            guessNumber = intInput.nextInt();
            foundIt = guessNumber == storedNumber;
            if (!foundIt) {
                lives-=1;
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
