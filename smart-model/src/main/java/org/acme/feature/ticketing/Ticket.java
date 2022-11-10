package org.acme.feature.ticketing;

import org.infinispan.protostream.annotations.ProtoField;

public class Ticket {

    @ProtoField(number = 1, defaultValue = "0")
    int id;

    @ProtoField(number = 2, defaultValue = "0")
    int deviceId;

    @ProtoField(number = 3)
    String featureName;

    @ProtoField(number = 4)
    TicketStatus status;

    @ProtoField(number = 5, defaultValue = "0")
    long createdOn;

    @ProtoField(number = 6, defaultValue = "0")
    int owner;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    public long getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(long createdOn) {
        this.createdOn = createdOn;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

}
