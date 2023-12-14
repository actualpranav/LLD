package Concurrenty.InterfaceRunnable;

public class Cat extends Animal implements Walkable{

    Cat(String s){
        Name = s;
    }
    public void walk(){
        System.out.println(Name + " is walking");
    }
}
