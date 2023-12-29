package Exceptions;

public class HandleErrors {
    static void twice(int a){
        twice(a + a);
    }

    public static void main(String[] args) {
//        twice(2);
        try{
            twice(2);
        }
        catch (StackOverflowError e) {
            System.out.println(e);
        }
    }
}
