package Concurrenty.MultiThreading.semaphores.Adder_Subtractor_Atomic;

import java.util.concurrent.Callable;
//import java.util.concurrent.Concurrenty.locks.Lock;
public class Subtractor implements Callable<Void>{
    SharedValue v;
    Subtractor(SharedValue v){
        this.v = v;
    }

    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 50000; i++){
            v.value.addAndGet(-i);
        }
        return null;
    }
}
