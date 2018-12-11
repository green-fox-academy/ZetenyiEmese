import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        dominoes.add(new Domino(2, 3));
        dominoes.add(new Domino(5, 1));


        System.out.println(dominoes);

        Collections.sort(dominoes);
        // the order of your dominoes should look like this: [[1,5], [2,3], [2,4], [4,6], [5,1], [5,2], [6,7], [7,1]]
        System.out.println(dominoes);


        List<ToDo> toDos = new ArrayList<>();
        toDos.add(new ToDo("Remove the obstacles"));

        ToDo toDo3 = new ToDo("Stand up");
        toDo3.complete();
        toDos.add(toDo3);

        toDos.add(new ToDo("Get milk"));

        ToDo toDo4  = new ToDo("Eat lunch");
        toDo4.complete();
        toDos.add(toDo4);

        System.out.println(toDos);

        Collections.sort(toDos);
        System.out.println(toDos);
    }

}
