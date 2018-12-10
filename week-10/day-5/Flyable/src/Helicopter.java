public class Helicopter extends Vehicle implements Flyable {

    @Override
    public void land() {
    }

    @Override
    public void fly() {
        System.out.println("Rotating the propeller");
    }

    @Override
    public void takeOff() {
    }

}
