package DesignPatterns.decorator.starbuzz.addOns;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Milk implements Beverage {
    Beverage base;
    public Milk(Beverage base){
        this.base = base;
    }
    @Override
    public int getCost() {
        return 20 + base.getCost();
    }

    @Override
    public String getDescription() {
        return "Milk ," + base.getDescription();
    }
}
