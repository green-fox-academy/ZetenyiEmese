public class Main {

    public static void main(String[] args) {
        Garden myGarden = new Garden();

        myGarden.add(new Flower("yellow"));
        myGarden.add(new Flower("blue"));
        myGarden.add(new Tree("purple"));
        myGarden.add(new Tree("orange"));

        System.out.println(myGarden);

        myGarden.water(40);
        System.out.println(myGarden);

        myGarden.water(70);
        System.out.println(myGarden);
    }

}
