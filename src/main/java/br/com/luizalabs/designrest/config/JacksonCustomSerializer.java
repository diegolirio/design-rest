package br.com.luizalabs.designrest.config;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JacksonCustomSerializer {

    public static final String DATE_FORMTAER = "dd/MM/yyyy - HH:mm";

    public static class CustomLocalDateDeserializer extends StdDeserializer<LocalDateTime> {

        public CustomLocalDateDeserializer() {
            this(null);
        }
        public CustomLocalDateDeserializer(Class<?> vc) {
            super(vc);
        }
        @Override
        public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMTAER);
            return LocalDateTime.parse(jsonParser.readValueAs(String.class), formatter);
        }
    }

    public static class CustomLocalDateSerializer extends StdSerializer<LocalDateTime> {
        protected CustomLocalDateSerializer() {
            this(null);
        }
        protected CustomLocalDateSerializer(Class<LocalDateTime> t) {
            super(t);
        }
        @Override
        public void serialize(LocalDateTime value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeString(value.format(DateTimeFormatter.ofPattern(DATE_FORMTAER)));
        }
    }
}
