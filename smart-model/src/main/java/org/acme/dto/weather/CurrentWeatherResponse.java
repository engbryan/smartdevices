package org.acme.dto.weather;

import org.infinispan.protostream.annotations.ProtoField;

public class CurrentWeatherResponse {

    @ProtoField(number = 1, required = true)
    String city;

    @ProtoField(number = 2, required = true)
    String country;

    @ProtoField(number = 3, required = true, defaultValue = "0")
    float temp;

    @ProtoField(number = 4, name = "feels_like", required = true, defaultValue = "0")
    float feelsLike;

    @ProtoField(number = 5, name = "temp_min", required = true, defaultValue = "0")
    float temp_min;

    @ProtoField(number = 6, name = "temp_max", required = true, defaultValue = "0")
    float tempMax;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(float feelsLike) {
        this.feelsLike = feelsLike;
    }

    public float getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(float temp_min) {
        this.temp_min = temp_min;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

}
