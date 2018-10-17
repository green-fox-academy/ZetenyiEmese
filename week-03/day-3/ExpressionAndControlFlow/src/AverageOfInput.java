import java.util.Scanner;
public class AverageOfInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 5 integers in a row:");
        int nr1 = input.nextInt();
        int nr2 = input.nextInt();
        int nr3 = input.nextInt();
        int nr4 = input.nextInt();
        int nr5 = input.nextInt();

        int sum = nr1+nr2+nr3+nr4+nr5;
        double average = (nr1+nr2+nr3+nr4+nr5)/5.;

        System.out.println("Sum: " + sum + ", Average: " + average);
    }
}
