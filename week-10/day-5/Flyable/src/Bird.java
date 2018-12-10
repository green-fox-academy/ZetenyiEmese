public class Bird extends Animal implements Flyable {

    public Bird() {
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
