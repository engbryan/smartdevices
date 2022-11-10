package org.acme.service;

import org.acme.dto.weather.CurrentWeatherRequest;
import org.acme.dto.weather.CurrentWeatherResponse;
import org.acme.feature.IService;
import org.acme.annotation.ProtoService;

@ProtoService
public abstract class WeatherService implements IService<CurrentWeatherResponse, CurrentWeatherRequest> {

    @Override
    public CurrentWeatherResponse invoke(CurrentWeatherRequest request) {

        var response = new CurrentWeatherResponse();

        return response;
    }
}
