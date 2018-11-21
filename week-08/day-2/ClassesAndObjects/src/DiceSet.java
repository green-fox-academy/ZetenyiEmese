import java.util.ArrayList;

public class DiceSet {
    private ArrayList<Integer> dice = new ArrayList<>();

    public int getNumberOfDices(){
        return dice.size();
    }

    public ArrayList<Integer> roll() {
        for (int i = 0; i < 6; i++) {
            dice.add((int) (Math.random() * 6) + 1);
        }
        return dice;
    }

    public ArrayList<Integer> getCurrent() { //check the current rolled numbers of all the dices
        return dice;
    }

    public int getCurrent(int i) { //check the current rolled number of the ith dice
        return dice.get(i);
    }

    public void reroll() { //reroll all dices
        for (int i = 0; i < dice.size(); i++) {
            dice.set(i, (int) (Math.random() * 6) + 1);
        }
    }

    public void reroll(int k) { //reroll the kth dice
        dice.set(k, (int) (Math.random() * 6) + 1);
    }

    public static void main(String[] args) {
        // You have a `DiceSet` class which has a list for 6 dice
        // You can roll all of them with roll()
        // Check the current rolled numbers with getCurrent()
        // You can reroll with reroll()
        // Your task is to roll the dices until all of the dice are 6

        DiceSet diceSet = new DiceSet();
        System.out.println(diceSet.getCurrent());

        System.out.println(diceSet.roll());
        System.out.println(diceSet.getCurrent());

        System.out.println(diceSet.getCurrent(5));

        diceSet.reroll();
        System.out.println(diceSet.getCurrent());

        diceSet.reroll(4);
        System.out.println(diceSet.getCurrent());

        for (int i = 0; i < diceSet.getNumberOfDices(); i++) {
            while (diceSet.getCurrent(i) != 6) {
                diceSet.reroll(i);
            }
        }
        System.out.println(diceSet.getCurrent());
    }
}