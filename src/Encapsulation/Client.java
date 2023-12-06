package Encapsulation;

public class Client {


    public static void main(String[] args) {
        // using constructor1
        ConstructorExample ob = new ConstructorExample("blackpearl", 25);
        // using default constructor
        ConstructorExample ob1 = new ConstructorExample();
        // using constructor 2
        ConstructorExample ob2 = new ConstructorExample(20, "voyager");
        // using copy constructor
        ConstructorExample ob3 = new ConstructorExample(ob);

        System.out.println(ob.boatLength +  "  " +  ob.boatName);
        System.out.println(ob1.boatLength +  "  " +  ob1.boatName);
        System.out.println(ob2.boatLength +  "  " +  ob2.boatName);
        System.out.println(ob3.boatLength +  "  " +  ob3.boatName);

        ConstructorExample ob4 = ob1;
        System.out.println(ob4.boatLength);
        ob4.boatLength = 10;
        System.out.println(ob4.boatLength);
        System.out.println(ob1.boatLength);
//        ob4 = null;
//        System.out.println(ob1.boatLength);
        swap(ob2, ob4);
        System.out.println(ob2.boatLength + " should be 10");
        System.out.println(ob4.boatLength + " should be 20");

    }

    public static void swap(ConstructorExample ob2, ConstructorExample ob4){
        ConstructorExample temp = ob2;
        ob2 = ob4;
        ob4 = temp;
    }
}
