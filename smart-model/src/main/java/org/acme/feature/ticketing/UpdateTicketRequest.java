package org.acme.feature.ticketing;

import org.infinispan.protostream.annotations.ProtoField;

public class UpdateTicketRequest {

    @ProtoField(number = 1, defaultValue="0")
    int id;

    @ProtoField(number = 2)
    TicketStatus status;

    public UpdateTicketRequest() {
    }

    public UpdateTicketRequest(int id, TicketStatus status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public TicketStatus getStatus() {
        return status;
    }

}
