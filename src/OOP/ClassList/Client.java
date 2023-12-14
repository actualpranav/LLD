package OOP.ClassList;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Animal Dog = new Animal("Dog");
        Animal Cat = new Animal("Cat");
        Animal Sparrow = new Animal("Sparrow");
        Animal Shark = new Animal("Shark");

        List<Animal> list= new ArrayList<>();
        list.add(Dog);
        list.add(Cat);
        list.add(Sparrow);
        list.add(Shark);
        for(Animal a : list){
            a.breathing();
        }

    }
}
