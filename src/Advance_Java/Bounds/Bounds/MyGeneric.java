package Advance_Java.Bounds.Bounds;

import java.util.List;

public class MyGeneric {
    public static <T extends Animal> void doSomething(List<T> list){
        for(T t : list){
            System.out.println(t.name);
        }
    }
}
