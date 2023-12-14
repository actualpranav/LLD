package Concurrenty.locks.adder_subtractor;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    private SharedValue v;
    private Lock lock;

    Subtractor(SharedValue x, Lock l){
            v = x;
            lock = l;
    }

    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 50; i++){
            lock.lock();
            v.value -= i;
            lock.unlock();
        }
        return null;
    }
}
