package org.acme.dto;

import com.google.gson.annotations.SerializedName;

public class OpenWeatherData {

    public static class Main {

        private float temp;

        @SerializedName("feels_like")
        private float feelsLike;

        @SerializedName("temp_min")
        private float tempMin;

        @SerializedName("temp_max")
        private float tempMax;

        public float getTemp() {
            return temp;
        }

        public float getFeelsLike() {
            return feelsLike;
        }

        public float getTempMin() {
            return tempMin;
        }

        public float getTempMax() {
            return tempMax;
        }

    }

    private static class Sys {

        private String country;
    }

    @SerializedName("name")
    private String city;

    private Main main;

    private Sys sys;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return sys.country;
    }

    public Main getMain() {
        return main;
    }

}
