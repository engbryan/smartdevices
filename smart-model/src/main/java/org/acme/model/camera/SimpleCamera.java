package org.acme.model.camera;

import java.util.List;
import org.acme.annotation.ProtoService;
import org.acme.dto.BooleanResponse;
import org.acme.dto.FeatureRequest;
import org.acme.dto.DeviceFeatureResponse;
import org.acme.dto.Int32Response;
import org.acme.dto.StringResponse;
import org.acme.dto.VoidRequest;
import org.acme.dto.camera.*;
import org.acme.model.ICamera;

@ProtoService
public abstract class SimpleCamera implements ICamera {

    public BooleanResponse reboot(VoidRequest request) {

        var status = this.reboot();

        return new BooleanResponse(status);
    }

    public StreamResponse getStream(VoidRequest request) {
        return new StreamResponse();
    }

    public FrameResponse getFrame(FrameRequest request) {
        return new FrameResponse();
    }

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

    public StringResponse getFirmwareVersion(VoidRequest request) {

        var firmwareVersion = this.getFirmwareVersion();

        return new StringResponse(firmwareVersion);
    }

    public StringResponse getHardwareVersion(VoidRequest request) {

        var hardwareVersion = this.getHardwareVersion();

        return new StringResponse(hardwareVersion);
    }

    public StringResponse getModel(VoidRequest request) {

        var model = this.getModel();

        return new StringResponse(model);
    }

    public StringResponse getBrand(VoidRequest request) {

        var brand = this.getBrand();

        return new StringResponse(brand);
    }

}
