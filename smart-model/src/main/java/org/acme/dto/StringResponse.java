package org.acme.dto;

import org.infinispan.protostream.annotations.ProtoField;

public class StringResponse {

    @ProtoField(number = 1, required = true)
    String value;

    public StringResponse() {

    }

    public StringResponse(String value) {
        this.value = value;
    }
}
