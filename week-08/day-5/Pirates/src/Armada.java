import java.util.ArrayList;

public class Armada {

    private String name;
    private ArrayList<Ship> ships;

    public Armada(String name) {
        this.name = name;
        this.ships = new ArrayList<>();
    }

    public void add(Ship newShip) {
        ships.add(newShip);
    }

    public boolean war(Armada otherArmada) {
        int indexThis = 0;
        int indexOther = 0;

        int sizeThisArmada = this.ships.size();
        int sizeOtherArmada = otherArmada.ships.size();

        while (indexThis < sizeThisArmada && indexOther < sizeOtherArmada) {
            Ship thisShip = this.ships.get(indexThis);
            Ship otherShip = otherArmada.ships.get(indexOther);

            if (thisShip.battle(otherShip)) {
                display(this.name, indexThis, thisShip, otherArmada.name, indexOther, otherShip);
                indexOther++;

            } else {
                display(otherArmada.name, indexOther, otherShip, this.name, indexThis, thisShip);
                indexThis++;
            }
        }

        if (indexOther == sizeOtherArmada) return true;
        return false;
    }

    private void display(String winnerName, int iWinner, Ship winnerShip, String loserName, int iLoser, Ship loserShip) {
        System.out.println("The winner ship: ship " + (iWinner + 1) +
                           " from " + winnerName + "\n" + winnerShip +
                           "\nThe loser ship: ship " + (iLoser + 1) +
                           " from " + loserName + "\n" + loserShip + "\n");
    }

    @Override
    public String toString() {
        String info = name + "\n";
        for (Ship ship : ships) {
            info += ship;
        }
        return info;
    }

}
