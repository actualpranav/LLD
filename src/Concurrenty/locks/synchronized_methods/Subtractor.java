package Concurrenty.locks.synchronized_methods;
import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void>{
    SharedValue v;

    Subtractor(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 5000; i++){
            v.decrementBy(i);
        }
        return null;
    }

}
