package Collections;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Something {
    public static void main(String[] args){
        DemoClass way1 = new DemoClass();
        way1.fun();

        DemoInterface way2 = new DemoInterface() {
            @Override
            public void fun() {
                System.out.println("\nanonymous class, way of creating object of interface without using clas");
            }
        };

        way2.fun();

        DemoInterface way3 = () ->
            System.out.println("\nLambda way to implement and call the interface function");

        way3.fun();

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.length() > 10;
            }
        };
        System.out.println("\n");
        System.out.println(predicate.test("yourregularstringthatpassesthetest"));
        System.out.println(predicate.test("idont"));

        Predicate<String> predicate1 = (str) -> str.length() > 10;
        System.out.println(predicate1.test("bigstringthatdoesntfailstest"));
        System.out.println(predicate1.test("small"));

        BiFunction<String, String, String> biFunction = (s1, s2) -> s1 + s2;
        System.out.println(biFunction.apply("Hello", " world"));

    }

}
