import java.util.ArrayList;

public class Farm {
    private static int maxSlots = 10; //maximum number of animals on the farm (the capacity)
    private ArrayList<Animal> animals;

    public Farm(){
        this(8);
    }

    public Farm(int numberOfAnimals) {
        animals = initializeAnimals(numberOfAnimals);
    }

    public ArrayList<Animal> initializeAnimals(int numberOfAnimals) {
        ArrayList<Animal> sharpies = new ArrayList<>();
        if (numberOfAnimals > maxSlots) {
            numberOfAnimals = maxSlots;
        }

        for (int i = 0; i < numberOfAnimals; i++) {
            sharpies.add(new Animal());
        }

        return sharpies;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public int getFreeSlots() {
        return maxSlots - animals.size();
    }

    public void feed(Animal animal){
        animal.eat();
        animal.drink();
    }

    public void feed(){
        for (Animal animal : animals) {
            animal.eat();
            animal.drink();
        }
    }

    public void breed() {
        if (getFreeSlots() > 0) {
            animals.add(new Animal());
        }
    }

    public void slaughter() {
        Animal leastHungry = animals.get(0);

        for (int i = 1; i < animals.size(); i++) {
            if (animals.get(i).getHunger() < leastHungry.getHunger()) {
                leastHungry = animals.get(i);
            }
        }

        animals.remove(leastHungry);
    }

    @Override
    public String toString() {
        return "Farm{" +
                "animals=" + animals +
                '}';
    }
}