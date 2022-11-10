package org.acme.model.lamp;

import java.util.List;
import org.acme.model.ILamp;
import org.acme.dto.VoidRequest;
import org.acme.dto.BooleanResponse;
import org.acme.dto.lamp.LampBright;
import org.acme.annotation.ProtoService;
import org.acme.dto.FeatureRequest;
import org.acme.dto.DeviceFeatureResponse;
import org.acme.dto.Int32Response;
import org.acme.dto.StringResponse;

@ProtoService
public abstract class DimmableLamp implements ILamp {

    public final BooleanResponse reboot(VoidRequest request) {

        var status = this.reboot();

        return new BooleanResponse(status);
    }

    public final BooleanResponse on(VoidRequest request) {

        var status = this.on();

        return new BooleanResponse(status);
    }

    public final BooleanResponse off(VoidRequest request) {

        var status = this.off();

        return new BooleanResponse(status);
    }

    public final Int32Response getId(VoidRequest request) {

        var id = this.getId();

        return new Int32Response(id);
    }

    public final StringResponse getName(VoidRequest request) {

        var name = this.getName();

        return new StringResponse(name);
    }

    public final StringResponse getVersion(VoidRequest request) {

        var version = this.getVersion();

        return new StringResponse(version);
    }

    public final DeviceFeatureResponse getFeatures(VoidRequest request) {

        List<FeatureRequest> features = this.getFeatures();

        var response = new DeviceFeatureResponse(features);

        return response;
    }

    public final StringResponse getFirmwareVersion(VoidRequest request) {

        var firmwareVersion = this.getFirmwareVersion();

        return new StringResponse(firmwareVersion);
    }

    public final StringResponse getHardwareVersion(VoidRequest request) {

        var hardwareVersion = this.getHardwareVersion();

        return new StringResponse(hardwareVersion);
    }

    public final StringResponse getModel(VoidRequest request) {

        var model = this.getModel();

        return new StringResponse(model);
    }

    public final StringResponse getBrand(VoidRequest request) {

        var brand = this.getBrand();

        return new StringResponse(brand);
    }

    public final LampBright getBright(VoidRequest request) {

        var bright = this.getBright();

        return new LampBright(bright);
    }

    public final BooleanResponse setBright(LampBright request) {

        var status = this.setBright(request.getValue());

        return new BooleanResponse(status);
    }

    public abstract int getBright();

    public abstract boolean setBright(int value);

}
