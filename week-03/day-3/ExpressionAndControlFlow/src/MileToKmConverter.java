import java.util.Scanner;
public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the distance in km: ");
        int distance = input.nextInt();
        System.out.println("The given distance in mile: " + (distance * 0.62137));
    }
}
