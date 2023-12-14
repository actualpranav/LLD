package OOP.OutEncapsulation;

import OOP.Encapsulation.Parent;

public class OutChild extends Parent {
    public static void main(String[] args) {
        Parent ob = new Parent();
        ob.Name = "pranav";
        System.out.println(ob.Name);

    }
}
