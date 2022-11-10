package org.acme.dto.camera;

import org.infinispan.protostream.annotations.ProtoField;

public class FrameRequest {

    @ProtoField(number = 1, defaultValue = "0")
    int position;
}
