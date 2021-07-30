package com.qdtdhl.campus.common.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.postgis.Geometry;
import org.postgis.GeometryBuilder;
import org.springframework.boot.jackson.JsonComponent;

import java.io.IOException;
import java.sql.SQLException;

//@JsonComponent
//public class GeometryDeserializer extends JsonDeserializer<Geometry> {
//    @Override
//    public Geometry deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
//        String wkt = jsonParser.getText();
//        try{
//            Geometry geometry = GeometryBuilder.geomFromString(wkt);
//            return geometry;
//        }catch (SQLException e){
//            return null;
//        }
//
//    }
//}


@JsonComponent
public class GeometryDeserializer extends JsonDeserializer<Geometry> {
    @Override
    public Geometry deserialize(JsonParser jsonParser,
                                DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        String wkt = jsonParser.getText();
        try {
            return GeometryBuilder.geomFromString("SRID=4326;" + wkt);
        } catch (SQLException e) {
            return null;
        }
    }
}