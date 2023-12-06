package Encapsulation;

public class ConstructorExample {
    public String boatName;
    public int boatLength;

    // default constructor
    ConstructorExample(){
        boatLength = 12;
        boatName = "myboat";
    }
    // constructor 1
    ConstructorExample(String NameValue, int lengthValue){
        boatLength = lengthValue;
        boatName = NameValue;
    }
    // constructor 2
    ConstructorExample(int lengthValue, String NameValue){
        boatLength = lengthValue;
        boatName = NameValue;
    }

    // copy constructor
    ConstructorExample(ConstructorExample ex){
        boatLength = ex.boatLength;
        boatName = ex.boatName;
    }
}
