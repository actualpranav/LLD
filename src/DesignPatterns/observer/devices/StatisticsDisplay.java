package DesignPatterns.observer.devices;

import DesignPatterns.observer.Observer;
import DesignPatterns.observer.WeatherData;

public class StatisticsDisplay implements Observer {
    WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        double formula = temp + (humidity/20) + pressure*10;
        System.out.println("some average formula of weather " + formula);
    }
}
