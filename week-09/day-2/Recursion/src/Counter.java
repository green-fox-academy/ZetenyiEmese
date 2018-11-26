public class Counter {

    public static void main(String[] args) {
        countDown(10);
        System.out.println();
        countUp(10);
    }

    public static void countDown(int n){
        System.out.println(n);
        if (n > 0) {
            countDown(n - 1);
        }
    }

    public static void countUp(int n){
        if (n > 0) {
            countUp(n - 1);
        }
        System.out.println(n);
    }
}
