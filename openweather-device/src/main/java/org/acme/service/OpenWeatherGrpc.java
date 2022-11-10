package org.acme.service;

import com.google.gson.Gson;
import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import org.acme.dto.OpenWeatherData;
import org.acme.grpc.Dto;

@GrpcService
public class OpenWeatherGrpc implements WeatherService {

    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_1_1)
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid=a64a9a01985e1c1fc819163febfc5931&units=metric&lang={lang}";

    private final Gson gson = new Gson();

    @Override
    public Uni<Dto.CurrentWeatherResponse> invoke(Dto.CurrentWeatherRequest request) {

        var builder = Dto.CurrentWeatherResponse.newBuilder();

        try {
            var url = API_URL
                    .replace("{lat}", String.valueOf(request.getLat()))
                    .replace("{lon}", String.valueOf(request.getLon()))
                    .replace("{lang}", request.getLang());

            var apiRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            var apiResponse = httpClient.send(apiRequest, HttpResponse.BodyHandlers.ofString());

            var json = apiResponse.body();

            OpenWeatherData data = gson.fromJson(json, OpenWeatherData.class);

            builder.setCity(data.getCity());

            builder.setCountry(data.getCountry());

            var dataMain = data.getMain();

            builder.setTemp(dataMain.getTemp());

            builder.setFeelsLike(dataMain.getFeelsLike());

            builder.setTempMin(dataMain.getTempMin());

            builder.setTempMax(dataMain.getTempMax());

        } catch (IOException | InterruptedException ex) {

        }

        Dto.CurrentWeatherResponse reposnse = builder.build();

        return Uni.createFrom()
                .item(reposnse);
    }

}
