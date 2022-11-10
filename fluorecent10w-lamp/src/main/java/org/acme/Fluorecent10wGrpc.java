package org.acme;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

import org.acme.grpc.Dto;
import org.acme.model.lamp.StaticLamp;
import org.acme.smartfeature.TurnOff;
import org.acme.smartfeature.TurnOn;

@GrpcService
public class Fluorecent10wGrpc implements StaticLamp {

    private boolean currentState = false;

    @Override
    public Uni<Dto.BooleanResponse> off(Dto.VoidRequest request) {

        System.out.println("Shutting down");

        var uni = Uni.createFrom();

        var builder = Dto.BooleanResponse.newBuilder();

        if (currentState == false) {

            System.out.println("Error: Lamp is already off");

            var status = builder.setSuccess(false).build();

            return uni.item(status);
        }

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException ex) {
        }

        currentState = false;

        System.out.println("New state: " + currentState);

        var status = builder.setSuccess(true).build();

        return uni.item(status);
    }

    @Override
    public Uni<Dto.BooleanResponse> on(Dto.VoidRequest request) {

        System.out.println("Turning on");

        var uni = Uni.createFrom();

        var builder = Dto.BooleanResponse.newBuilder();

        if (currentState == true) {

            System.out.println("Error: Lamp is already on");

            var status = builder.setSuccess(false).build();

            return uni.item(status);
        }

        try {
            Thread.sleep(1000l);
        } catch (InterruptedException ex) {
        }

        currentState = true;

        var status = builder.setSuccess(true).build();

        return uni.item(status);
    }

    @Override
    public Uni<Dto.BooleanResponse> reboot(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.TicketResponse> invokeFeature(Dto.FeatureRequest request) {

        var response = Uni.createFrom();

        var builder = Dto.TicketResponse.newBuilder();

        var ticket = Dto.Ticket.newBuilder();

        ticket.setStatus(Dto.TicketStatus.FAILED);

        var className = request.getName();

        var turnOnLamp = TurnOn.class.getName();

        if (turnOnLamp.equals(className)) {

            this.on(Dto.VoidRequest.newBuilder().build());

            ticket.setStatus(Dto.TicketStatus.SUCCEEDED);

            builder.setTicket(ticket.build());

            return response.item(builder.build());
        }

        var turnOffLamp = TurnOff.class.getName();

        if (turnOffLamp.equals(className)) {

            this.off(Dto.VoidRequest.newBuilder().build());

            ticket.setStatus(Dto.TicketStatus.SUCCEEDED);

            builder.setTicket(ticket.build());

            return response.item(builder.build());
        }

        return response.item(builder.build());
    }

    @Override
    public Uni<Dto.StringResponse> getName(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.Int32Response> getId(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.StringResponse> getVersion(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.StringResponse> getFirmwareVersion(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.StringResponse> getHardwareVersion(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.StringResponse> getBrand(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Uni<Dto.StringResponse> getModel(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
