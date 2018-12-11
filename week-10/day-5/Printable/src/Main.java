import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Printable> printables = new ArrayList<>();

        printables.add(new Domino(5, 2));
        printables.add(new Domino(4, 6));
        printables.add(new Domino(1, 5));
        printables.add(new Domino(6, 7));
        printables.add(new Domino(2, 4));
        printables.add(new Domino(7, 1));

        printables.add(new ToDo("Get milk"));
        printables.add(new ToDo("Remove the obstacles"));

        ToDo thing3 = new ToDo("Stand up");
        thing3.complete();
        printables.add(thing3);

        ToDo thing4 = new ToDo("Eat Lunch");
        thing4.complete();
        printables.add(thing4);

        for (Printable p : printables) {
            p.printAllFields();
        }

    }

}
