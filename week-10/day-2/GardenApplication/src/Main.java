public class Main {

    public static void main(String[] args) {

        Garden garden = new Garden();

        garden.add(new Flower("yellow"));
        garden.add(new Flower("blue"));
        garden.add(new Tree("purple"));
        garden.add(new Tree("orange"));

        System.out.println(garden);

        garden.water(40);
        System.out.println("Watering with 40");
        System.out.println(garden);

        garden.water(70);
        System.out.println("Watering with 70");
        System.out.println(garden);
    }
}
