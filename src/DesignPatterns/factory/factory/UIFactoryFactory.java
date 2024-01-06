package DesignPatterns.factory.factory;

public class UIFactoryFactory {
    public static UIFactory getUiFactoryBasedOnPlatform(String platform){
        if(platform.equals("Android")){
            return new AndroidUIFactory();
        }
        else if(platform.equals("Ios")){
            return new IOSUIFactory();
        }
        return null;
    }
}
