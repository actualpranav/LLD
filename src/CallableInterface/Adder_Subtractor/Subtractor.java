package CallableInterface.Adder_Subtractor;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private SharedValue v;

    Subtractor(SharedValue x){
        v = x;
    }

    @Override
    public Void call() throws Exception {
        for(int i = 1; i <= 5000; i++){
            v.value -= i;
        }
        return null;
    }
}