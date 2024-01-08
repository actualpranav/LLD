package DesignPatterns.dynamicObserver.devices;

import DesignPatterns.dynamicObserver.Observer;
import DesignPatterns.dynamicObserver.WeatherData;

public class CurrentConditionsDisplay implements Observer {
    WeatherData weatherData;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.println("CCD: current conditions are temp: " + temp + ", humidity: " + humidity + ", pressure: " + pressure);

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
