public class DoubleItems {
    public static void main(String[] args) {
        int[] numList = {3, 4, 5, 6, 7};
        doubling(numList);
        display(numList);
    }

    public static void doubling(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] *= 2;
        }
    }

    public static void display(int[] array){
        for (int x: array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
