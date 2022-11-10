package org.acme;

import java.time.Duration;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import org.acme.service.WeatherService;
import org.acme.grpc.Dto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class OpenWeatherGrpcTest {

    
    @GrpcClient
    WeatherService openWeatherGrpc;

    @Test
    public void testGetCurrent() {

        var lat = Double.parseDouble("52.524");

        var lon = Double.parseDouble("13.411");

        
        var builder = Dto.CurrentWeatherRequest.newBuilder()
                .setLat(lat)
                .setLon(lon)
                .setLang("en_us");

        Dto.CurrentWeatherRequest request = builder.build();
        
        var response = openWeatherGrpc.invoke(request)
                
                .await().atMost(Duration.ofSeconds(5));

        assertEquals("DE", response.getCountry());

    }

}
