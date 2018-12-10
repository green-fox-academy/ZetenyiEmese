import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Flyable> flyables = new ArrayList<>();

        flyables.add(new Helicopter());
        flyables.add(new Bird());

        for (Flyable flyable : flyables) {
            System.out.print(flyable.getClass().getName() + ": ");
            flyable.fly();
        }

    }
}
