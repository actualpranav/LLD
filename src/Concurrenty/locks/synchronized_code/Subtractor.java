package Concurrenty.locks.synchronized_code;
import java.util.concurrent.Callable;
public class Subtractor implements Callable<Void>{
    SharedValue v;
    Subtractor(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception{
        for(int i = 0; i < 50000; i++){
            synchronized(v){
                v.value -= i;
            }
        }
        return null;
    }
}
