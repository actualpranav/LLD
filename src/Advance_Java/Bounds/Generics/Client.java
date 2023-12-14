package Advance_Java.Bounds.Generics;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        GenericMethods.doSomething("Saharsh");

//        Student st = new Student();
//        GenericMethods.doSomething(st);

        GenericMethods<Integer> integerMyGeneric = new GenericMethods<>();
        integerMyGeneric.saySomething(50);
        integerMyGeneric.doExtra("Mohit", " h ", 100);

        HashMap<String, Integer> mp = new HashMap<>();
        mp.put("Saharsh", 10);
        Integer x = mp.get("Saharsh");
    }
}
