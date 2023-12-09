package InterfaceRunnable;

public class Dog extends Animal implements Walkable{
    Dog(String s){
        Name = s;
    }
    public void walk(){
        System.out.println(Name + " is walking");
    }
}
