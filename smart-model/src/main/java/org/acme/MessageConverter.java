package org.acme;

import org.infinispan.protostream.SerializationContextInitializer;
import org.infinispan.protostream.annotations.AutoProtoSchemaBuilder;

@AutoProtoSchemaBuilder(
        basePackages = {
            "org.acme.dto",
            "org.acme.feature.ticketing"
        },
        autoImportClasses = true,
        schemaFileName = "dto.proto",
        schemaFilePath = "proto",
        schemaPackageName = "dto"
)
public interface MessageConverter extends SerializationContextInitializer {

}
