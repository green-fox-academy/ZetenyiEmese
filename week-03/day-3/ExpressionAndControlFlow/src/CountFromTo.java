import java.util.Scanner;
public class CountFromTo {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter the first number (integer):");
        int firstNumber = intInput.nextInt();

        System.out.println("Please enter the second number (integer):");
        int secondNumber = intInput.nextInt();

        if (!(secondNumber>firstNumber)) {
            System.out.println("The second number should be bigger");
        } else {
            int difference = secondNumber - firstNumber;
            for (int i=0; i<difference; i++){
                System.out.println(firstNumber+i);
            }
        }
    }
}
