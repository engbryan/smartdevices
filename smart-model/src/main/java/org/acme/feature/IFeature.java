package org.acme.feature;

import org.acme.feature.ticketing.*;

public interface IFeature<T, R> {

    String getName();

    Ticket createTicket(CreateTicketRequest request);

    Ticket getTicket(int id);

    Ticket updateTicket(UpdateTicketRequest request);

    T invoke(R request);
}
