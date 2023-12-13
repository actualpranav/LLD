package semaphores.Producer_Consumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
public class Client {
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        Store store = new Store(10);

        Semaphore producerSemaphore = new Semaphore(8);
        Semaphore consumerSemaphore = new Semaphore(0);

        for(int i = 0; i < 8; i++){
            Producer p = new Producer(store, producerSemaphore, consumerSemaphore);
            es.execute(p);
        }

        for(int i = 0; i < 11; i++){
            Consumer c = new Consumer(store, producerSemaphore, consumerSemaphore);
            es.execute(c);
        }
    }
}
