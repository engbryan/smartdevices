package org.acme.dto;

import java.util.List;
import org.infinispan.protostream.annotations.ProtoField;

public class DeviceFeatureResponse {

    @ProtoField(number = 1)
    List<FeatureRequest> features;

    public DeviceFeatureResponse() {

    }

    public DeviceFeatureResponse(List<FeatureRequest> features) {
        this.features = features;
    }

    public List<FeatureRequest> getFeatures() {
        return features;
    }
}
