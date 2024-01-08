package DesignPatterns.strategy.pathFinders;

public class CarPathCal implements PathCalculator{
    private static CarPathCal Instance = new CarPathCal();
    private CarPathCal(){}

    public static CarPathCal getInstance(){
        return Instance;
    }
    @Override
    public void findPath(String from, String to){
        System.out.println("Take Highway 6");
    }
}
