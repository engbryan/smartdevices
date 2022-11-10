package org.acme.dto;

import org.infinispan.protostream.annotations.ProtoField;

public class VoidRequest {

    @ProtoField(number = 1)
    String nullValue;
}
