public class SumDigit {
    public static void main(String[] args) {
        System.out.println(sumDigit(542870036));
    }

    public static int sumDigit(int number){
        if (number == 0) {
            return 0;
        } else {
            return number % 10 + sumDigit(number / 10);
        }
    }
}
