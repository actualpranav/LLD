package locks.producer_consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Client {
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();

        Store store = new Store(10);

        for(int i = 0; i < 8; i++){
            Producer p = new Producer(store);
            es.execute(p);
        }
        for(int i = 0; i < 20; i++){
            Consumer c = new Consumer(store);
            es.execute(c);
        }
        es.shutdown();

    }
}
