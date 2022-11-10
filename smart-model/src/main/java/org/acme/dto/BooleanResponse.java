package org.acme.dto;

import org.infinispan.protostream.annotations.ProtoField;

public class BooleanResponse {

    @ProtoField(number = 1, required = true, defaultValue = "false")
    boolean success;

    public BooleanResponse() {

    }

    public BooleanResponse(boolean success) {
        this.success = success;
    }
}
