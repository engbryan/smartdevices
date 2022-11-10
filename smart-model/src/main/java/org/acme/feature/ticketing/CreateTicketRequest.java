package org.acme.feature.ticketing;

import org.infinispan.protostream.annotations.ProtoField;

public class CreateTicketRequest {

    @ProtoField(number = 1)
    TicketStatus status;

    public CreateTicketRequest() {
    }

    public CreateTicketRequest(TicketStatus status) {
        this.status = status;
    }

    public TicketStatus getStatus() {
        return status;
    }

}
