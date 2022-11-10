package org.acme;

import io.grpc.ManagedChannelBuilder;
import org.acme.grpc.Dto;
import org.acme.smartfeature.TurnOn;

//Generated by protoc
import org.acme.grpc.Dto.FeatureRequest;
import org.acme.grpc.Dto.StringParamsRequest;
import org.acme.model.lamp.StaticLampGrpc;
import org.acme.smartfeature.TurnOff;
//

public class LampClient {

    public static void main(String[] args) {

        var console = System.console();

        var address = "localhost:30001";

        var channel = ManagedChannelBuilder.forTarget(address)
                .usePlaintext()
                .build();

        var client = StaticLampGrpc.newBlockingStub(channel);

        var params = StringParamsRequest.newBuilder()
                .build();

        var cmd = console.readLine("Enter command: ");

        while (!cmd.equals("exit")) {

            Dto.Ticket ticket = null;

            if (cmd.equals("on")) {
                var fatureName = TurnOn.class.getName();

                var request = FeatureRequest.newBuilder()
                        .setName(fatureName)
                        .setParams(params)
                        .build();

                var response = client.invokeFeature(request);

                ticket = response.getTicket();

            }

            if (cmd.equals("off")) {
                var fatureName = TurnOff.class.getName();

                var request = FeatureRequest.newBuilder()
                        .setName(fatureName)
                        .setParams(params)
                        .build();

                var response = client.invokeFeature(request);

                ticket = response.getTicket();

            }

            if (ticket == null) {
                System.out.println("Invalid command. Enter on | off | exit");
	    } else {
                System.out.println("Ticket status: " + ticket.getStatus());
            }

            cmd = console.readLine("Enter new command: ");
        }

    }

}
