public class Pirate {

    private int maxConsumedRum = 5;
    private String name;
    private int consumedRum;
    private boolean alive;
    private boolean awake;

    public Pirate() {
        this.name = generateName();
        this.consumedRum = 0;
        this.alive = true;
        this.awake = true;
    }

    private String generateName() {
        String[] names = {"Joe", "Jack", "Sam", "Freddy", "Charles", "Louis", "Robert", "Rose", "Mary", "Jane"};
        int randomIndex = (int)(Math.random() * 10); // 0 -> 9
        return names[randomIndex];
    }

    public int getConsumedRum() {
        return consumedRum;
    }

    public boolean isAlive() {
        return alive;
    }

    public void drinkSomeRum() {
        if (!alive) {
            System.out.println(getClass().getName() + " " + name + " is dead!");
        } else if (!awake){
            System.out.println(getClass().getName() + " " + name + " is sleeping!");
        } else if (consumedRum < maxConsumedRum) {
            consumedRum++;
            if (consumedRum >= maxConsumedRum) {
                this.awake = false;
            }
        }
    }

    public void howsItGoingMate() {
        if (!alive) {
            System.out.println(getClass().getName() + " " + name + " is dead!");
        } else if (!awake) {
            System.out.println(getClass().getName() + " " + name + " is sleeping!");
        } else if (consumedRum < maxConsumedRum) {
            System.out.println("Pour me anudder!");
            consumedRum++;
            if (consumedRum >= maxConsumedRum) {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.awake = false;
            }
        }
    }

    public void die() {
        this.alive = false;
    }

    public void brawl(Pirate anotherPirate) {
        if (this.alive && this.awake && anotherPirate.alive && anotherPirate.awake) {
            int number = 1 + (int)(Math.random() * 3); // 1, 2 or 3
            //System.out.println(number);

            if (number == 1) {
                this.alive = false;
            } else if (number == 2) {
                anotherPirate.alive = false;
            } else {
                this.awake = false;
                anotherPirate.awake = false;
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s: %s, consumed rum: %d",
                             getClass().getName(),
                             name,
                             alive ? (awake ? "alive and awake" : "alive but sleeping") : "dead",
                             consumedRum);
    }

}
