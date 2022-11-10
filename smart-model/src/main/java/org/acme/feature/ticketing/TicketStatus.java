package org.acme.feature.ticketing;

import org.infinispan.protostream.annotations.ProtoEnumValue;

public enum TicketStatus {

    @ProtoEnumValue(number = 0)
    CREATED,
    @ProtoEnumValue(number = 1)
    FAILED,
    @ProtoEnumValue(number = 2)
    SUCCEEDED;
}
