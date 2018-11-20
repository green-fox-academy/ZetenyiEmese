public class Animal {
    private int hunger;
    private int thirst;

    public Animal() {
        this.hunger = 50;
        this.thirst = 50;
    }

    public void eat(){
        hunger--;
    }

    public void drink(){
        thirst--;
    }

    public void play(){
        hunger++;
        thirst++;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "hunger=" + hunger +
                ", thirst=" + thirst +
                '}';
    }

    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println(animal);

        animal.eat();
        System.out.println(animal);

        animal.drink();
        System.out.println(animal);

        animal.play();
        System.out.println(animal);
    }
}