package semaphores.Adder_Subtractor_Atomic;

import java.util.concurrent.Callable;
//import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private SharedValue v;
    Adder(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 50000; i++){
            v.value.addAndGet(i);
        }
        return null;
    }
}
