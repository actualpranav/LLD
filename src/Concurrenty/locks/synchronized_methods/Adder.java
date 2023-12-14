package Concurrenty.locks.synchronized_methods;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void>{
    SharedValue v;


    Adder(SharedValue x){
        v = x;
    }

    @Override
    public synchronized Void call() throws Exception{
        for(int i = 0; i < 5000; i++){
            v.incrementBy(i);
        }
        return null;
    }
}
