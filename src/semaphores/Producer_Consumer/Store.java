package semaphores.Producer_Consumer;

import java.util.concurrent.ConcurrentLinkedDeque;
//import java.util.List;
//import java.util.ArrayList;
public class Store {
    private int maxSize;
    private ConcurrentLinkedDeque<Object> items;

    Store(int maxSize){
        this.maxSize = maxSize;
        items = new ConcurrentLinkedDeque<>();
    }

    public int getMaxSize(){
        return maxSize;
    }

    public ConcurrentLinkedDeque<Object> getItems(){
        return items;
    }

    public void addItems(){
        this.items.addLast(new Object());
        System.out.println("add items, current size " + this.items.size());
    }

    public void removeItems(){
        this.items.removeLast();
        System.out.println("remove items, current size " + this.items.size());
    }
}
