package locks.adder_subtractor;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private SharedValue v;
    private Lock lock;
    Adder(SharedValue x, Lock lock){
        v = x;
        this.lock = lock;
    }
    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 50; i++){
            lock.lock();
            v.value += i;
            lock.unlock();
        }
        return null;
    }
}
