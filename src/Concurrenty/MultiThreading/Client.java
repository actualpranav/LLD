package Concurrenty.MultiThreading;

public class Client {
    public static void main(String[] args) {
//        Scanner
        HelloWorldPrinter x = new HelloWorldPrinter();
        Thread t = new Thread(x);
        t.start();
        System.out.println("main function, thread : " + Thread.currentThread().getName());
    }
}
