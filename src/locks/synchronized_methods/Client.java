package locks.synchronized_methods;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        SharedValue v = new SharedValue();

        Adder adderTask = new Adder(v);
        Subtractor subtractorTask = new Subtractor(v);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(adderTask);
        Future<Void> subtractorFuture = es.submit(subtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);



    }
}
