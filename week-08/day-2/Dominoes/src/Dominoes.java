import java.util.ArrayList;
import java.util.List;

public class Dominoes {
    public static void main(String[] args) {
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...

        List<Domino> dominoes = initializeDominoes();

        System.out.println(dominoes);
        order(dominoes);
        System.out.println(dominoes);
    }

    public static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();

        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));

        return dominoes;
    }

    public static List<Domino> order(List<Domino> dominoes){
        for (int i = 0; i < dominoes.size()-1; i++) {
            for (int j = i + 1; j < dominoes.size(); j++) {
                if (dominoes.get(j).getLeftSide() == dominoes.get(i).getRightSide()) {
                    dominoes.add(i + 1, dominoes.get(j));
                    dominoes.remove(j + 1);
                    break;
                }
            }
        }
        return dominoes;
    }
}