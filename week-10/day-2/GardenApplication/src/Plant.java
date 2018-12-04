public class Plant {

    private String color;
    private double waterLevel;

    public Plant(String color) {
        this(color, 0);
    }

    public Plant(String color, int waterLevel) {
        this.color = color;
        this.waterLevel = waterLevel;
    }

    public String getColor() {
        return color;
    }

    public double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public boolean needsWater() {
        return waterLevel < 5;
    }

    public void water(double waterAmount) {
        waterLevel += waterAmount;
    }
}
