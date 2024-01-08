package DesignPatterns.strategy;
public class Client {
    public static void main(String[] args) {
        GoogleMaps googleMaps = new GoogleMaps();
        googleMaps.findPath("Mumbai", "Pune", "CAR");
        googleMaps.findPath("Mumbai", "Pune", "TRAIN");

    }
}
