package locks.synchronized_code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
public class Client {
    public static void main(String[] args) throws InterruptedException, ExecutionException{
        SharedValue v = new SharedValue();
        Adder AdderTask = new Adder(v);
        Subtractor SubtractorTask = new Subtractor(v);

        ExecutorService es = Executors.newCachedThreadPool();

        Future<Void> adderFuture = es.submit(AdderTask);
        Future<Void> subtractorFuture = es.submit(SubtractorTask);

        adderFuture.get();
        subtractorFuture.get();

        System.out.println(v.value);
    }
}
