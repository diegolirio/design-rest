package br.com.luizalabs.designrest.config;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JsonDeserialize(using = JacksonCustomSerializer.CustomLocalDateDeserializer.class)
@JsonSerialize(using = JacksonCustomSerializer.CustomLocalDateSerializer.class)
public @interface JacksonLocalDate {

}