package org.acme.dto;

import java.util.List;
import org.infinispan.protostream.annotations.ProtoField;

public class StringParamsRequest {

    @ProtoField(number = 1)
    List<String> items;

    public StringParamsRequest() {

    }

    public StringParamsRequest(List<String> items) {
        this.items = items;
    }

    public List<String> getItems() {
        return items;
    }

}
