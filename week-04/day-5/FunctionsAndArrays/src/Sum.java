import java.util.Scanner;

public class Sum {
    static Scanner intInput = new Scanner(System.in);
    static int endParameter = -1;

    public static void main(String[] args) {
        System.out.println("I can sum up numbers until you enter " + endParameter);
        System.out.println("The sum of the entered numbers: " + sum());
    }

    public static int sum(){
        int sum = 0;
        int number = inputANumber();

        while (number != endParameter){
            sum += number;
            number = inputANumber();
        }
        return sum;
    }

    public static int inputANumber(){
        System.out.println("Enter the number to sum up: ");
        return(intInput.nextInt());
    }
}
