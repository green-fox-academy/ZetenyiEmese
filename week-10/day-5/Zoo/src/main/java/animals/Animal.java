package main.java.animals;

public abstract class Animal{

    private String name;
    private int age;
    private String gender;
    private boolean isHungry;
    private boolean isAsleep;


    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isHungry = true;
        this.isAsleep = false;
    }

    public String getName() {
        return name;
    }

    public void eat() {
        System.out.println("Eating");
    }

    public void sleep() {
        System.out.println("Sleeping");
    }

    public String move() {
        return "moving";
    }

    public abstract String breed();

}
