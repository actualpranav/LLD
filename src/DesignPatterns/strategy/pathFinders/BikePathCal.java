package DesignPatterns.strategy.pathFinders;

public class BikePathCal implements PathCalculator{
    private static BikePathCal Instance = new BikePathCal();
    private BikePathCal(){}

    public static BikePathCal getInstance() {
        return Instance;
    }

    @Override
    public void findPath(String from, String to){
        System.out.println("Take City Cycle Path");

    }
}
