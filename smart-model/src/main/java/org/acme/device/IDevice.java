package org.acme.device;

import java.util.List;
import org.acme.dto.FeatureRequest;

public interface IDevice {

    int getId();

    String getName();

    String getVersion();

    <T> List<T> getFeatures();
    
    <R> R invokeFeature(FeatureRequest feature);
}
