package Advance_Java.Bounds.Generics;

public class GenericMethods <S>{
    public static <T> void doSomething(T parameter){
        System.out.println(parameter);
    }

    public void saySomething(S param){
        System.out.println(param + " saying something");
    }

    public <E, R> R doExtra(E param, R secondParam, S thirdParam){
        System.out.println(param + " saying something");
        System.out.println(secondParam);
        System.out.println(thirdParam);
        return secondParam;
    }

}
