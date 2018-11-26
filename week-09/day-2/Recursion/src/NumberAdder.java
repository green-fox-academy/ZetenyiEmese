public class NumberAdder {

    public static void main(String[] args) {
        System.out.println(addNumbers(10));
    }

    public static int addNumbers(int n){
        if (n == 1){
            return 1;
        } else {
            return n + addNumbers(n - 1);
        }
    }
}
