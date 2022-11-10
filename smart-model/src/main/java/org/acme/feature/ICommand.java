package org.acme.feature;

import org.acme.feature.ticketing.TicketResponse;

public interface ICommand<R> extends IFeature<TicketResponse, R> {

}
