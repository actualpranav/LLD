package DesignPatterns.dynamicObserver.devices;

import DesignPatterns.dynamicObserver.Observer;
import DesignPatterns.dynamicObserver.WeatherData;

public class StatisticsDisplay implements Observer {
    WeatherData weatherData;

    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        double formula = temp + (humidity/20) + pressure*10;
        System.out.println("SD: some average formula of weather " + formula);
    }

    @Override
    public void startListening() {
        weatherData.registerObserver(this);
    }

    @Override
    public void stopListening() {
        weatherData.removeObserver(this);
    }
}
