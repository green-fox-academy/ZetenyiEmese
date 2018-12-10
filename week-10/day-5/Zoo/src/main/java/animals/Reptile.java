package main.java.animals;

public class Reptile extends Egglaying {

    public Reptile(String name) {
        super(name, 0, "female");
    }

    @Override
    public String move() {
        return "snaking";
    }

}
