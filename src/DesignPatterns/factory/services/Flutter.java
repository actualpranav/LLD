package DesignPatterns.factory.services;

import DesignPatterns.factory.factory.UIFactory;
import DesignPatterns.factory.factory.UIFactoryFactory;

public class Flutter {
    public void setRefreshRate(){
        System.out.println("Setting Refresh Rate");
    }

    public void setTheme(){
        System.out.println("Setting theme");
    }

    public UIFactory createUIFactory(String platform){
        return UIFactoryFactory.getUiFactoryBasedOnPlatform(platform);
    }
}
