package DesignPatterns.factory;

import DesignPatterns.factory.components.Button.Button;
import DesignPatterns.factory.factory.UIFactory;
import DesignPatterns.factory.services.Flutter;
import DesignPatterns.factory.services.ReactNative;

public class Client {
    public static void main(String[] args) {
        Flutter f = new Flutter();
        f.setRefreshRate();
        f.setTheme();

        UIFactory uiFactory = f.createUIFactory("Android");
        Button b = uiFactory.createButton();
        b.getSizeOfButton();

        ReactNative reactNative = new ReactNative();
        UIFactory uiFactory1 = reactNative.createUIFactory("Ios");
        Button b2 = uiFactory1.createButton();
        b2.getSizeOfButton();
    }
}
