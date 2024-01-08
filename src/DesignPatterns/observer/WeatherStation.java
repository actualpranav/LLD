package DesignPatterns.observer;

import DesignPatterns.observer.devices.CurrentConditionsDisplay;
import DesignPatterns.observer.devices.ForecastDisplay;
import DesignPatterns.observer.devices.StatisticsDisplay;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.setMeasurements(28.5, 80, 2);
        weatherData.setMeasurements(30, 78, 3.1);

        weatherData.registerObserver(forecastDisplay);
        weatherData.setMeasurements(27, 74, 1.8);

        weatherData.removeObserver(currentConditionsDisplay);
        weatherData.setMeasurements(12, 67, 4);
        weatherData.setMeasurements(24, 89, 1.2);
    }



}
