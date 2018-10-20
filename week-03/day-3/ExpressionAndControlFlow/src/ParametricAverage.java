import java.util.Scanner;
public class ParametricAverage {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("How many numbers would you like to work with?:");
        int numberOfData = intInput.nextInt();

        int inputData;
        int sum=0;

        for (int i=0; i<numberOfData; i++) {
            System.out.println("Enter the number (integer):");
            inputData = intInput.nextInt();
            sum = sum + inputData;
        }

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (double)sum/numberOfData);
    }
}
