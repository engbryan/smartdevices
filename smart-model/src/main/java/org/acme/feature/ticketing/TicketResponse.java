package org.acme.feature.ticketing;

import org.infinispan.protostream.annotations.ProtoField;

public class TicketResponse {

    @ProtoField(number = 1)
    Ticket ticket;

    public TicketResponse() {

    }

    public TicketResponse(Ticket ticket) {
        this.ticket = ticket;
    }

}
