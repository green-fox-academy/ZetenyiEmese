public class Cuboid {
    public static void main(String[] args) {
        double side1 = 25.89;
        double side2 = 78.24;
        double side3 = 37.62;

        double surfaceArea = 2*(side1*side2+side1*side3+side2*side3);
        double volume = side1*side2*side3;

        System.out.println("Surface area: " + surfaceArea);
        System.out.println("Volume: " + volume);
    }
}
