package org.acme.dto.weather;

import org.infinispan.protostream.annotations.ProtoField;

public class CurrentWeatherRequest {

    @ProtoField(number = 1, required = true, defaultValue = "0")
    double lat;

    @ProtoField(number = 2, required = true, defaultValue = "0")
    double lon = 2;

    @ProtoField(number = 3, required = true)
    String lang;

    public CurrentWeatherRequest() {

    }

    public CurrentWeatherRequest(double lat, double lon, String lang) {
        this.lat = lat;
        this.lon = lon;
        this.lang = lang;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public String getLang() {
        return lang;
    }

}
