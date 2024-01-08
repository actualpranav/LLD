package DesignPatterns.decorator.starbuzz.addOns;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Mocha implements Beverage {
    Beverage base;
    public Mocha(Beverage base){
        this.base = base;
    }
    @Override
    public int getCost() {
        return 40 + base.getCost();
    }

    @Override
    public String getDescription() {
        return "Mocha ," + base.getDescription();
    }
}
