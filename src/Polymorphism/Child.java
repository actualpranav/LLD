package Polymorphism;

public class Child extends Parent{
    String School;
    Child(){
        Name = "christ";
        Phone = 100;
        School = "KKPS";
    }
//    @Override
    void AllDetails() {
        super.AllDetails(); // Call the parent's method
        System.out.println("\n child details");
        System.out.println(School + " School ");
    }


//    @Override
    void AllDetails(int i){
        while(i-- > 0) AllDetails();
    }

//    void SchoolDetails(){
//        System.out.println(School + " School details form child");
//    }
}
