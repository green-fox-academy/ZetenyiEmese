public class Bunny1 {

    public static void main(String[] args) {
        System.out.println(addFloppyEars(12));
    }

    public static int addFloppyEars(int bunnies){
        if (bunnies > 1){
            return 2 + addFloppyEars(bunnies - 1);
        }
        return 2;
    }
}
