package org.acme.dto;

import java.util.List;
import org.infinispan.protostream.annotations.ProtoField;

public class FeatureRequest {

    @ProtoField(number = 2, required = true)
    String name;

    @ProtoField(number = 1, required = true)
    StringParamsRequest params;

    public FeatureRequest() {

    }

    public FeatureRequest(String name, StringParamsRequest params) {
        this.name = name;
        this.params = params;
    }

    public String getName() {
        return name;
    }

    public StringParamsRequest getParams() {
        return params;
    }

}
