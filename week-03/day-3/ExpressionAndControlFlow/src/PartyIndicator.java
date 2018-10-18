import java.util.Scanner;
public class PartyIndicator {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter the number of girls:");
        int numberOfGirls = intInput.nextInt();

        System.out.println("Please enter the number of boys:");
        int numberOfBoys = intInput.nextInt();

        int numberOfPeople = numberOfGirls+numberOfBoys;

        if ( numberOfPeople>=20) {
            if (numberOfGirls == numberOfBoys) {
                System.out.println("The party is excellent!");
            } else {
                System.out.println("Quite cool party!");
            }
        } else {
            System.out.println("Average party!");
        }

        if (numberOfGirls==0){
            System.out.println("Sausage party!");
        }
    }
}
