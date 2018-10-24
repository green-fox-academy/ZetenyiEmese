import java.util.Scanner;

public class Factorio {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Give me a number, I will calculate the factorial of it: ");
        int number = intInput.nextInt();

        System.out.println("The factorial of the given number is: " + factorio(number));
    }

    public static int factorio(int n){
        int factorial = 1;
        for (int i = 0; i < n; i++) {
            factorial *= i+1;
        }
        return factorial;
    }
}
