package org.acme;

import org.acme.model.lamp.StaticLamp;
import io.quarkus.grpc.GrpcClient;
import io.quarkus.test.junit.QuarkusTest;
import java.time.Duration;
import org.acme.grpc.Dto;
import org.acme.smartfeature.TurnOn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class StaticLampOnTest {

    @GrpcClient
    StaticLamp client;

    @Test
    public void turnOn() {

        var params = Dto.StringParamsRequest.newBuilder()
                .build();

        var fatureName = TurnOn.class.getName();

        var request = Dto.FeatureRequest.newBuilder()
                .setName(fatureName)
                .setParams(params)
                .build();

        var response = client.invokeFeature(request);

        var ticket = response
                .await()
                .atMost(Duration.ofSeconds(5))
                .getTicket();

        assertEquals(Dto.TicketStatus.SUCCEEDED, ticket.getStatus());

    }
}
