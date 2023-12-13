package locks.producer_consumer;

//import java.util.concurrent.Runnable;
public class Producer implements Runnable{
    private Store store;

    Producer(Store s){
        store = s;
    }

    @Override
    public void run(){
        while(true)
            synchronized (store) {
                if (store.getItems().size() < store.getMaxSize()) store.addItems();
            }
    }
}
