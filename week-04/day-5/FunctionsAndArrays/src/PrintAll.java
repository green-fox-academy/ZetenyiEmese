public class PrintAll {
    public static void main(String[] args) {
        int[] numbers = {4, 5, 6, 7};
        printAll(numbers);
    }

    public static void printAll(int[] array){
        for (int item: array) {
            System.out.print(item + " ");
        }
    }
}
