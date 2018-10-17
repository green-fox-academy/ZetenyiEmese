public class Cuboid {
    public static void main(String[] args) {
        double side1, side2, side3, surfaceArea, volume;
        side1=25.89;
        side2=64.45;
        side3=37.62;

        surfaceArea=2*(side1*side2+side1*side3+side2*side3);
        volume=side1*side2*side3;

        System.out.println("Surface area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }
}
