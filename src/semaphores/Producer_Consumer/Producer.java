package semaphores.Producer_Consumer;

import java.util.concurrent.Semaphore;
public class Producer implements Runnable{
    private  Store store;
    private Semaphore producerSemaPhore;
    private Semaphore consumerSemaPhore;

    Producer(Store s, Semaphore p, Semaphore c){
        store = s;
        producerSemaPhore = p;
        consumerSemaPhore = c;
    }
    @Override
    public void run(){
        while(true){
            try{
                producerSemaPhore.acquire();
                Thread.sleep(10);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            store.addItems();;
            consumerSemaPhore.release();
        }
    }
}
