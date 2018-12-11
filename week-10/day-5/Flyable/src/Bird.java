public class Bird extends Animal implements Flyable {

    public Bird() {
    }

    public Bird(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String breed() {
        return  "Laying eggs";
    }

    @Override
    public void land() {
    }

    @Override
    public void fly() {
        System.out.println("Fluttering with wings");
    }

    @Override
    public void takeOff() {
    }

}
