import java.util.ArrayList;

public class Ship {

    private Captain captain;
    private ArrayList<Pirate> crew;

    public Ship() {
        this.captain = null;
        this.crew = new ArrayList<>();
    }

    public void fillShip() {
        captain = new Captain();

        int numberOfPirates = 10 + (int)(Math.random() * 11); // 10 -> 20
        //System.out.println(numberOfPirates);

        for (int i = 0; i < numberOfPirates; i++) {
            crew.add(new Pirate());
        }
    }

    public boolean battle(Ship otherShip) {
        int thisScore = numberOfAlivePirates() - captain.getConsumedRum();
        int otherScore = otherShip.numberOfAlivePirates() - otherShip.captain.getConsumedRum();

        if (thisScore > otherScore) {
            otherShip.slaughter();
            this.haveParty();
            return true;
        } else if (thisScore < otherScore) {
            this.slaughter();
            otherShip.haveParty();
            return false;
        }
        return false;
    }

    private void slaughter() {
        int numberOfDeaths = (int) (Math.random() * (numberOfAlivePirates() + 1));
        //System.out.println(numberOfDeaths);

        ArrayList<Pirate> alivePirates = getAlivePirates();
        for (int i = 0; i < numberOfDeaths; i++) {
            alivePirates.get(i).die();
        }
    }

    private void slaughter2() {
        int numberOfDeaths = (int) (Math.random() * (numberOfAlivePirates() + 1));
        //System.out.println(numberOfDeaths);

        if (numberOfDeaths > 0) {
            int counter = 0;
            for (Pirate pirate : crew) {
                if (pirate.isAlive()) {
                    pirate.die();
                    counter++;
                }
                if (counter == numberOfDeaths) {
                    return;
                }
            }
        }
    }

    private void haveParty() {
        int rumForCaptain = 2 + (int)(Math.random() * 4); // 2 -> 5
        for (int i = 0; i < rumForCaptain; i++) {
            captain.drinkSomeRum();
        }

        for (Pirate pirate : crew) {
            int rumForPirate = 1 + (int)(Math.random() * 3); // 1 -> 3
            for (int i = 0; i < rumForPirate; i++) {
                pirate.drinkSomeRum();
            }
        }
    }

    private int numberOfAlivePirates() {
        int number = 0;
        for (Pirate pirate : crew) {
            if (pirate.isAlive()) {
                number++;
            }
        }
        return number;
    }

    private ArrayList<Pirate> getAlivePirates() {
        ArrayList<Pirate> alivePirates = new ArrayList<>();
        for (Pirate pirate : crew) {
            if (pirate.isAlive()) {
                alivePirates.add(pirate);
            }
        }
        return alivePirates;
    }

    @Override
    public String toString() {
        return  captain + "\n" + String.format("The crew: %d alive pirates", numberOfAlivePirates()) + "\n";
    }

}
