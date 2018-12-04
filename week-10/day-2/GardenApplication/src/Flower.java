public class Flower extends Plant {

    public Flower(String color) {
        super(color);
    }

    @Override
    public void water(double waterAmount) {
        setWaterLevel(getWaterLevel() + 0.75 * waterAmount);
    }

    @Override
    public String toString() {
        return "The " + getColor() + " flower " + (needsWater() ? "needs" : "doesn't need") + " water";
    }
}
