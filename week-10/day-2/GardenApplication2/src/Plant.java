public class Plant {

    private String type;
    private String color;
    private float waterLevel;
    private float criticalWaterLevel;
    private float waterAbsorption;

    public Plant(String type, String color, float criticalWaterLevel, float waterAbsorption) {
        this.type = type;
        this.color = color;
        this.waterLevel = 0;
        this.criticalWaterLevel = criticalWaterLevel;
        this.waterAbsorption = waterAbsorption;
    }

    public boolean needsWater() {
        return waterLevel < criticalWaterLevel;
    }

    public void water(int waterAmount) {
        waterLevel += waterAmount * waterAbsorption;
    }

    @Override
    public String toString() {
        return String.format("The %s %s %s water", color, type, needsWater()? "needs" : "doesn't need");
    }

}
