import java.util.ArrayList;

public class Garden {

    private ArrayList<Plant> plants;

    public Garden() {
        this.plants = new ArrayList<>();
    }

    public void add(Plant plant) {
        plants.add(plant);
    }

    public void water(int waterAmount) {
        System.out.println("Watering with " + waterAmount);

        int numberOfThirstyPlants = countThirstyPlants();
        //System.out.println(numberOfThirstyPlants);

        for (Plant plant : plants) {
            plant.water(waterAmount / numberOfThirstyPlants);
        }
    }

    private int countThirstyPlants() {
        int sum = 0;

        for (Plant plant : plants) {
           if (plant.needsWater()) {
               sum ++;
           }
        }

        return sum;
    }

    @Override
    public String toString() {
        String info = "";

        for (Plant plant : plants) {
            info += plant + "\n";
        }

        return info;
    }

}