package DesignPatterns.decorator;

import DesignPatterns.decorator.starbuzz.Beverage;
import DesignPatterns.decorator.starbuzz.addOns.Milk;
import DesignPatterns.decorator.starbuzz.addOns.Mocha;
import DesignPatterns.decorator.starbuzz.addOns.Whip;
import DesignPatterns.decorator.starbuzz.types.DeepRoast;
import DesignPatterns.decorator.starbuzz.types.Espresso;

public class Client {
    public static void main(String[] args) {
        Beverage b = new Espresso();
        b = new Milk(b);
        System.out.println(b.getDescription());
        System.out.println(b.getCost());

        System.out.println();

        Beverage d = new DeepRoast();
        d = new Mocha(d);
        d = new Mocha(d);
        d = new Milk(d);
        d = new Whip(d);

        System.out.println(d.getDescription());
        System.out.println(d.getCost());


    }
}
