import java.util.Arrays;
import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println("An Armstrong number is an n-digit number that is equal to the sum of the nth powers of its digits.");
        System.out.println("For example: 153 is a 3-digit number and 1^3 + 5^3 + 3^3 = 153, so it is an Armstrong number.");
        System.out.println("Give me an n-digit number, I will check if it's an Armstrong number or not:");

        Scanner textInput = new Scanner(System.in);
        String numberString = textInput.nextLine();

        display(numberString, isArmstrongNumber(numberString));
    }

    public static  boolean isArmstrongNumber(String numberString){
        int number = Integer.parseInt(numberString); //this is the number to be examined if it is an Armstrong number
        int[] digits = new int[numberString.length()]; //this array contains the digits of the examined number

        for (int i = 0; i < digits.length; i++) {
            char c = numberString.charAt(i);
            digits[i] = Character.getNumericValue(c);
        }

        //Here I calculate the sum of the nth powers of the digits, where n is the number of digits in the examined number:
        int sum = 0;
        for (int d: digits) {
            int dd = 1;
            for (int i = 1; i <= digits.length; i++){
                dd *= d;
            }
            sum += dd;
        }
        return number == sum;
    }

    public static void display(String numberString, boolean itIsANr){
        if (itIsANr){
            System.out.println("The " + numberString + " is an Armstrong number.");
        } else {
            System.out.println("The " + numberString + " is not an Armstrong number.");
        }
    }

}
