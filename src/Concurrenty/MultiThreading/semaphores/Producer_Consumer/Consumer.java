package Concurrenty.MultiThreading.semaphores.Producer_Consumer;

import java.util.concurrent.Semaphore;
public class Consumer implements Runnable{
    private Store store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    Consumer(Store s, Semaphore p, Semaphore c){
        store = s;
        producerSemaphore = p;
        consumerSemaphore = c;
    }

    @Override
    public void run(){
        while(true){
            try{
                consumerSemaphore.acquire();
                Thread.sleep(10);
            }
            catch(InterruptedException e){
                throw new RuntimeException(e);
            }
            store.removeItems();
            producerSemaphore.release();
        }
    }

}
