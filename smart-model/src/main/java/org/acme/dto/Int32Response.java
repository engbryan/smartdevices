package org.acme.dto;

import org.infinispan.protostream.annotations.ProtoField;

public class Int32Response {

    @ProtoField(number = 1, required = true, defaultValue = "0")
    int value;

    public Int32Response() {

    }

    public Int32Response(int value) {
        this.value = value;
    }
}
