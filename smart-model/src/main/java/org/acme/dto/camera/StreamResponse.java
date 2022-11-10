package org.acme.dto.camera;

import org.infinispan.protostream.annotations.ProtoField;

public class StreamResponse {

    @ProtoField(number = 1)
    byte[] data;
}
