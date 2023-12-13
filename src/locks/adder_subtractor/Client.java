package locks.adder_subtractor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.Future;
public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Lock lock = new ReentrantLock();
        SharedValue v = new SharedValue();

        Adder adderTask = new Adder(v, lock);
        Subtractor subtractorTask = new Subtractor(v, lock);

        ExecutorService es =  Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(adderTask);
        Future<Void> subtractorFuture = es.submit(subtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);
        es.shutdown();
    }
}
