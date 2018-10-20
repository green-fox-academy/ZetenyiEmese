import java.util.Scanner;
public class DrawSquare {
    public static void main(String[] args) {
        Scanner intInput = new Scanner(System.in);

        System.out.println("Please enter a number (integer):");
        int number = intInput.nextInt();

        for (int i = 0; i < number; i++){
            if (i == 0 || i == number-1) {
                for (int j = 0; j < number; j++) {
                    System.out.print("%");
                }
                System.out.println();
            } else {
                for (int j = 0; j < number; j++){
                    if (j == 0){
                        System.out.print("%");
                    } else if (j == number-1){
                        System.out.print("%\n");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
        }
    }
}
