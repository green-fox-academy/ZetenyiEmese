import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        // Create a function that takes a number
        // divides ten with it,
        // and prints the result.
        // It should print "fail" if the parameter is 0

        Scanner intInput = new Scanner(System.in);
        int n = intInput.nextInt();

        divideTenByNumber(n);
    }

    public static void divideTenByNumber(int n) {
        try {
            System.out.println(10 / n);
        } catch (ArithmeticException e) {
            System.out.println("Fail!");
        }
    }
}
