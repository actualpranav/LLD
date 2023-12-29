package Exceptions;

public class CheckedException {
    static void doSomething(int rollNo) throws ClassNotFoundException{
        if(rollNo > 0){
            System.out.println("student details of roll number " + rollNo );
            return;
        }
        doSomethingElse();
    }

    static void doSomethingElse() throws ClassNotFoundException{
        throw new ClassNotFoundException();
    }
    public static void main(String[] args) throws ClassNotFoundException{
//        doSomething(20);
        doSomething(-10);
    }
}
