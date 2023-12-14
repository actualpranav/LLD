package Advance_Java.Bounds.Bounds;

public class Dog extends Animal{
    public String breed;

    Dog(String name, String breed){
        super(name);
        this.breed = breed;
    }

    public void bark(){
        System.out.println(" dog barks");
    }
}
