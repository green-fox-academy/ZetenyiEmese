import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter an integer:");
        int number = intInput.nextInt();

        if (number%2==0){
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }
    }
}
