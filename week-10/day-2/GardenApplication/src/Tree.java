public class Tree extends Plant{

    public Tree(String color) {
        super(color);
    }

    @Override
    public boolean needsWater() {
        return getWaterLevel() < 10;
    }

    @Override
    public void water(double waterAmount) {
        setWaterLevel(getWaterLevel() + 0.4 * waterAmount);
    }

    @Override
    public String toString() {
        return "The " + getColor() + " tree " + (needsWater() ? "needs" : "doesn't need") + " water";
    }
}
