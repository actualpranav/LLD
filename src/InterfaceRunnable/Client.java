package InterfaceRunnable;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        Cat c = new Cat("Cat");
        Dog d = new Dog("Dog");
        Ostrich o = new Ostrich("ostrich");
        Shark s = new Shark("Shark");

        ArrayList<Walkable> wanimals = new ArrayList<>();
        wanimals.add(c);
        wanimals.add(d);
        wanimals.add(o);
        for(Walkable w : wanimals){
            w.walk();
        }

        System.out.println(c.family);

//        ArrayList<Animal> allnimals = new ArrayList<>();
//        allnimals.add(c);
//        allnimals.add(d);
//        allnimals.add(o);
//        allnimals.add(s);
//        for(Animal w : allnimals){
//            w.walk();
//        }
    }
}
