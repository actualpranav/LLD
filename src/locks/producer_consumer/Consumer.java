package locks.producer_consumer;

public class Consumer implements Runnable{
    Store store;

    Consumer(Store s){
        store = s;
    }

    @Override
    public void run(){
        while(true)
            synchronized(store){
                if(store.getItems().size() > 0) store.removeItems();
            }
    }
}
