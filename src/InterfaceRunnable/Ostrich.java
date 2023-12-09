package InterfaceRunnable;

public class Ostrich extends Animal implements Walkable{
    Ostrich(String s){
        Name = s;
    }
    public void walk(){
        System.out.println(Name + " is walking");
    }
}
