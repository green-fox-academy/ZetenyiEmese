public class FarmMain {
    public static void main(String[] args) {
        Farm farm = new Farm();
        System.out.println(farm);

        farm.feed();
        System.out.println(farm);

        farm.breed();
        farm.breed();
        farm.breed();
        System.out.println(farm);

        Animal anAnimal1 = farm.getAnimals().get(1);
        farm.feed(anAnimal1);

        Animal anAnimal2 = farm.getAnimals().get(3);
        farm.feed(anAnimal2);
        farm.feed(anAnimal2);

        System.out.println(farm);

        farm.slaughter();
        System.out.println(farm);

        farm.slaughter();
        System.out.println(farm);
    }
}