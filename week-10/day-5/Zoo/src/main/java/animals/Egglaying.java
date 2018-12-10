package main.java.animals;

public abstract class Egglaying extends Animal {

    public Egglaying(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public String breed() {
        return "laying eggs.";
    }

}
