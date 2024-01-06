package DesignPatterns.factory.components.Button;

public class IOSButton implements Button{
    @Override
    public void getSizeOfButton() {
        System.out.println("IOS size button");
    }
}
