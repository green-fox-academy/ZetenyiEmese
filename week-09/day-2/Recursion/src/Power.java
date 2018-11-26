public class Power {

    public static void main(String[] args) {
        System.out.println(powerN(5, 3));
    }

    public static int powerN(int base, int n){
        if (n == 1){
            return base;
        } else {
            return base * powerN(base, n - 1);
        }
    }
}
