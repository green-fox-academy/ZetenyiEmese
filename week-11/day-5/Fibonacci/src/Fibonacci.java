import java.util.HashMap;

public class Fibonacci {

    private HashMap<Integer, Long> hm;

    public Fibonacci() {
        hm = new HashMap<>();
        hm.put(0, 0L);
        hm.put(1, 1L);
    }

    public long countFibonacci(int n) {
        if (n < 0) return 0;

        if (hm.containsKey(n)) {
            return hm.get(n);
        } else {
            long fibN = countFibonacci(n-2) + countFibonacci(n-1);
            hm.put(n, fibN);
            return fibN;
        }
    }

    //public static long fibonacci(int n) {
    //    if (n < 1) return 0;
    //    if (n == 1) return 1;
    //    return fibonacci(n-2) + fibonacci(n-1);
    //}

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.countFibonacci(50));

        //System.out.println(fibonacci(50));
    }

}
