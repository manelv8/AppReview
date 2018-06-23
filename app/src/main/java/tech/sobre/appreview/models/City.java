package tech.sobre.appreview.models;

import com.google.gson.annotations.SerializedName;

public class City {

    int id;
    String name;

    @SerializedName("main")
    Weather weather;

    @SerializedName("weather")
    WeatherConditions[] weatherConditions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public WeatherConditions[] getWeatherConditions() {
        return weatherConditions;
    }

    public void setWeatherConditions(WeatherConditions[] weatherConditions) {
        this.weatherConditions = weatherConditions;
    }
}
