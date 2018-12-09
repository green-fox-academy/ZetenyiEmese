import java.util.ArrayList;

public class Carrier {

    private int ammoStore;
    private int healthPoints;
    private ArrayList<Aircraft> aircrafts;

    public Carrier(int ammoStore, int healthPoints) {
        this.ammoStore = ammoStore;
        this.healthPoints = healthPoints;
        this.aircrafts = new ArrayList<>();
    }

    public void add(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    private boolean isEnoughAmmo() {
        return ammoStore > 0;
    }

    private void decreaseHealthPoints(int amount) {
        if (healthPoints > amount) {
            healthPoints -= amount;
        } else {
            healthPoints = 0;
        }
    }

    public void fill() {
        fill(getAircraftsWithThisPriority(true));
        fill(getAircraftsWithThisPriority(false));
    }


    private void fill(ArrayList<Aircraft> aircrafts) {
        for (Aircraft aircraft : aircrafts) {
            if (isEnoughAmmo()) {
                ammoStore = aircraft.refill(ammoStore);
            } else {
                System.out.println("No ammo!");
                return;
            }
        }
    }

    private ArrayList<Aircraft> getAircraftsWithThisPriority(boolean priority) {
        ArrayList<Aircraft> aircraftsWithThisPriority = new ArrayList<>();

        for (Aircraft aircraft : aircrafts) {
            if (aircraft.isPriority() == priority) {
                aircraftsWithThisPriority.add(aircraft);
            }
        }

        return aircraftsWithThisPriority;
    }

    public void fight(Carrier otherCarrier) {
        int allDamageCaused = 0;
        for (Aircraft aircraft : aircrafts) {
            allDamageCaused += aircraft.fight();
        }
        otherCarrier.decreaseHealthPoints(allDamageCaused);
    }

    public String getStatus() {
        if (healthPoints == 0) {
            return "It's dead Jim :(";
        }

        String info = "HP: " + healthPoints +
                      ", Aircraft count: " + aircrafts.size() +
                      ", Ammo Storage: " + ammoStore +
                      ", Total damage: " + totalDamage() + "\n" +
                      "Aircrafts: \n";

        for (Aircraft aircraft : aircrafts) {
            info += aircraft.getStatus() + "\n";
        }

        return info;
    }

    private int totalDamage() {
        int totalDamage = 0;
        for (Aircraft aircraft : aircrafts) {
            totalDamage += aircraft.getAmmo() * aircraft.getBaseDamage();
        }
        return totalDamage;
    }

}
