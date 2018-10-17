import java.util.Scanner;
public class AnimalsAndLegs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many chickens does the farmer have?");
        int numberOfChickens = input.nextInt();
        System.out.println("How many pigs does the farmer have?");
        int numberOfPigs = input.nextInt();

        int numberOfLegs = numberOfChickens*2 + numberOfPigs*4;

        System.out.println("The animals have got " + numberOfLegs + " legs in total." );
    }
}
