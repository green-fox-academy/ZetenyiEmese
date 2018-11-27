public class Bunny2 {

    public static void main(String[] args) {
        System.out.println(addFloppyEars(15));
        System.out.println(addFloppyEars2(15));
    }

    public static int addFloppyEars(int bunnies){
        if (bunnies > 1){
            if (bunnies % 2 == 0){
                return 3 + addFloppyEars(bunnies - 1);
            } else {
                return 2 + addFloppyEars(bunnies - 1);
            }
        }
        return 2;
    }

    public static int addFloppyEars2(int bunnies){
        if (bunnies > 1){
            return addFloppyEars(bunnies - 1) + (bunnies % 2 == 0 ? 3 : 2);
        }
        return 2;
    }
}
