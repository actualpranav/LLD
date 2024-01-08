package DesignPatterns.decorator.starbuzz.addOns;

import DesignPatterns.decorator.starbuzz.Beverage;

public class Whip implements Beverage {
    Beverage base;
    public Whip(Beverage base){
        this.base = base;
    }
    @Override
    public int getCost() {
        return 30 + base.getCost();
    }

    @Override
    public String getDescription() {
        return "Whip, " + base.getDescription();
    }
}
