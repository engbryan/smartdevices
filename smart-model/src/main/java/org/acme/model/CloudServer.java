package org.acme.model;

import java.util.List;
import org.acme.annotation.ProtoService;
import org.acme.device.IVirtualDevice;
import org.acme.dto.FeatureRequest;
import org.acme.dto.Int32Response;
import org.acme.dto.DeviceFeatureResponse;
import org.acme.dto.StringResponse;
import org.acme.dto.VoidRequest;

@ProtoService
public abstract class CloudServer implements IVirtualDevice {

    public Int32Response getId(VoidRequest request) {

        var id = this.getId();

        return new Int32Response(id);
    }

    public StringResponse getName(VoidRequest request) {

        var name = this.getName();

        return new StringResponse(name);
    }

    public StringResponse getVersion(VoidRequest request) {

        var version = this.getVersion();

        return new StringResponse(version);
    }

    public DeviceFeatureResponse getFeatures(VoidRequest request) {

        List<FeatureRequest> features = this.getFeatures();

        var response = new DeviceFeatureResponse(features);

        return response;
    }
}
