public class BattleApp {

    public static void main(String[] args) {
        Ship ship1 = new Ship();
        ship1.fillShip();
        System.out.println(ship1);

        Ship ship2 = new Ship();
        ship2.fillShip();
        System.out.println(ship2);

        for (int i = 0; i < 2; i++) {
            System.out.println((i+1) + ". BATTLE:\n");

            if (ship1.battle(ship2)) {
                display(ship1, ship2);
            } else {
                display(ship2, ship1);
            }
        }
    }

    private static void display(Ship winner, Ship loser) {
        System.out.println("The winner ship:\n" + winner);
        System.out.println("The loser ship:\n" + loser);
    }

}
