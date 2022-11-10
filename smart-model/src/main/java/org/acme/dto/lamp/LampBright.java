package org.acme.dto.lamp;

import org.infinispan.protostream.annotations.ProtoField;

public class LampBright {

    @ProtoField(number = 1, required = true, defaultValue = "0")
    int value;

    public LampBright() {

    }

    public LampBright(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
