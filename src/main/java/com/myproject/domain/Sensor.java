package com.myproject.domain;

public class Sensor {

    Integer temperature;
    Integer humidity;

    public Sensor() {}

    public Integer getTemperature() {
        return temperature;
    }
    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }
    public Integer getHumidity() {
        return humidity;
    }
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }
}
