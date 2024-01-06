package DesignPatterns.factory.components.Button;

public class AndroidButton implements Button{
    @Override
    public void getSizeOfButton(){
        System.out.println("Android size button");
    }
}
