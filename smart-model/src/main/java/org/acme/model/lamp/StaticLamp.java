package org.acme.model.lamp;

import org.acme.model.ILamp;
import org.acme.annotation.ProtoService;
import org.acme.dto.*;
import org.acme.feature.ticketing.*;

@ProtoService
public abstract class StaticLamp implements ILamp {

    public abstract BooleanResponse reboot(VoidRequest request);

    public abstract BooleanResponse on(VoidRequest request);

    public abstract BooleanResponse off(VoidRequest request);

    public abstract Int32Response getId(VoidRequest request);

    public abstract StringResponse getName(VoidRequest request);

    public abstract StringResponse getVersion(VoidRequest request);

    public abstract StringResponse getFirmwareVersion(VoidRequest request);

    public abstract StringResponse getHardwareVersion(VoidRequest request);

    public abstract StringResponse getModel(VoidRequest request);

    public abstract StringResponse getBrand(VoidRequest request);

    public abstract TicketResponse invokeFeature(FeatureRequest request);

}
