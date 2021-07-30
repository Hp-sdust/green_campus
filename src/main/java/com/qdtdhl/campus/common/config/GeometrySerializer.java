package com.qdtdhl.campus.common.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.postgis.Geometry;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;

@JsonComponent
public class GeometrySerializer extends JsonSerializer<Geometry> {
    @Override
    public void serialize(Geometry geometry, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        StringBuffer sb = new StringBuffer();
        geometry.outerWKT(sb);
        jsonGenerator.writeString(new String(sb));
    }
}