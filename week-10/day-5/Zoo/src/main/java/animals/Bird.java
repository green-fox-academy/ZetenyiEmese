package main.java.animals;

public class Bird extends Egglaying {

    public Bird(String name) {
        super(name, 0, "male");
    }

    @Override
    public String move() {
        return "flying or walking";
    }

}
