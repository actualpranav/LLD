package Polymorphism;

public class Parent {
    String Name;
    int Phone;

    Parent(){
        Name = "jesus";
        Phone = 911;
    }

//    void AllDetails(){
//        System.out.println("\n parent details");
//        System.out.println(Name + " Name");
//        System.out.println(Phone + " Phone");
//    }

    void AllDetails() {
        System.out.println("\n parent details");
        System.out.println(this.Name + " Name");
        System.out.println(this.Phone + " Phone");
    }

//    void SchoolDetails(){
//
//    }
}
