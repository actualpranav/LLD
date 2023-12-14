package Advance_Java.Bounds.Bounds;

import java.util.List;
import java.util.ArrayList;
public class Client {
    public static void main(String[] args) {
        Dog d1 = new Dog(" good boi", "golden retriever");
        Dog d2 = new Dog(" tom", "labrador");

        Cat c1 = new Cat("gatto");
        Cat c2 = new Cat("void");

        Bird b = new Bird("hawky", true);

        List<Animal> animals = new ArrayList<>();

        animals.add(d1);
        animals.add(d2);
        animals.add(c1);

        List<Dog> dogs = new ArrayList<>();
        dogs.add(d1);
        dogs.add(d2);

        List<Bird> birds = new ArrayList<>();
        birds.add(b);

        MyGeneric.doSomething(animals);
        System.out.println();

        Species sp = new Species();
        List<Species> manySpecies = new ArrayList<>();
        manySpecies.add(sp);
    }
}
