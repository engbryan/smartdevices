package org.acme.smartfeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.acme.dto.StringParamsRequest;
import org.acme.feature.ICommand;
import org.acme.feature.ticketing.*;

public abstract class AbstractCommand implements ICommand<StringParamsRequest> {

    private int ticketSequence = 1;

    private Map<Integer, Ticket> tickets;

    public AbstractCommand() {
        tickets = new HashMap<>();
    }
    
    @Override
    public final Ticket createTicket(CreateTicketRequest request) {

        var ticket = new Ticket();

        ticket.setId(ticketSequence++);

        ticket.setDeviceId(1);

        ticket.setFeatureName(this.getName());

        ticket.setCreatedOn(System.currentTimeMillis());

        ticket.setOwner(123);

        ticket.setStatus(request.getStatus());

        tickets.put(ticket.getId(), ticket);

        return ticket;

    }

    @Override
    public final Ticket getTicket(int id) {

        return tickets.get(id);
    }

    @Override
    public final Ticket updateTicket(UpdateTicketRequest request) {

        var ticket = tickets.get(request.getId());

        if (ticket == null) {
            return ticket;
        }

        ticket.setStatus(request.getStatus());

        return ticket;
    }

    @Override
    public final TicketResponse invoke(StringParamsRequest params) {

        var ticketRequest = new CreateTicketRequest(TicketStatus.CREATED);
        
        var ticket = this.createTicket(ticketRequest);

        new Thread() {
            @Override
            public void run() {

                var status = invoke(params.getItems());

                if (status == true) {
                    ticket.setStatus(TicketStatus.SUCCEEDED);
                } else {
                    ticket.setStatus(TicketStatus.FAILED);
                }
            }

        }.start();

        return new TicketResponse(ticket);
    }

    public abstract boolean invoke(List<String> params);
}
