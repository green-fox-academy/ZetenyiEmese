import java.util.ArrayList;

public class Garden {

    private ArrayList<Plant> plants;

    public Garden() {
        plants = new ArrayList<>();
    }

    public void add(Plant plant) {
        plants.add(plant);
    }

    public void water(double waterAmount) {
        for (Plant plant : plants) {
            if (plant.needsWater()) {
                plant.water(waterAmount / numberOfPlantsToBeWatered());
            }
        }
    }

    public int numberOfPlantsToBeWatered() {
        int number = 0;
        for (Plant plant : plants) {
            if (plant.needsWater()) {
                number++;
            }
        }
        return number;
    }

    @Override
    public String toString() {
        String info = "";
        for (Plant plant : plants) {
            info += plant.toString() + "\n";
        }
        return info;
    }
}
