package org.acme;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

//Generated by the protocol buffer compiler
import org.acme.grpc.Dto;
import org.acme.model.CloudServer;
//

@GrpcService
public class CloudServerGrpc implements CloudServer {

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
    public Uni<Dto.DeviceFeatureResponse> getFeatures(Dto.VoidRequest request) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}