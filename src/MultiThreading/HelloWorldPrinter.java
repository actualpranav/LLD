package MultiThreading;

public class HelloWorldPrinter implements Runnable {
    public void doSomething(){
        System.out.println("Do something, Thread : " + Thread.currentThread().getName());
    }

    @Override
    public void run(){
        doSomething();
        System.out.println("Hello world, Thread: " + Thread.currentThread().getName());
    }
}
