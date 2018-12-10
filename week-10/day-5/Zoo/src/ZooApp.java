import main.java.animals.*;

import java.util.ArrayList;

public class ZooApp {

    public static void main(String[] args) {

        Reptile reptile = new Reptile("Crocodile");
        Mammal mammal = new Mammal("Koala");
        Bird bird = new Bird("Parrot");

        System.out.println("How do you breed?");
        System.out.println("A " + reptile.getName() + " is breeding by " + reptile.breed());
        System.out.println("A " + mammal.getName() + " is breeding by " + mammal.breed());
        System.out.println("A " + bird.getName() + " is breeding by " + bird.breed());

        System.out.println();

        System.out.println("How do you move?");
        System.out.println("A " + reptile.getName() + " is moving: " + reptile.move());
        System.out.println("A " + mammal.getName() + " is moving: " + mammal.move());
        System.out.println("A " + bird.getName() + " is moving: " + bird.move());

        System.out.println();

        //All animals can breed() and move() but they do these in a different way:
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Reptile("Salamander"));
        animals.add(new Mammal("Fox"));
        animals.add(new Bird("Pigeon"));

        for (Animal animal : animals) {
            System.out.println("A " + animal.getName() + " is breeding by " + animal.breed());
            System.out.println("A " + animal.getName() + " is moving: " + animal.move());
        }

    }

}
