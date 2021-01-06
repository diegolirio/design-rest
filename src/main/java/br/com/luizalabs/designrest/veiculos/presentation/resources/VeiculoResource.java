package br.com.luizalabs.designrest.veiculos.presentation.resources;

import br.com.luizalabs.designrest.config.JacksonCustomSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class VeiculoResource {

    @NotNull
    @JsonDeserialize(using = JacksonCustomSerializer.CustomLocalDateDeserializer.class)
    @JsonSerialize(using = JacksonCustomSerializer.CustomLocalDateSerializer.class)
    private LocalDate dataLance;

    @NotNull
    private String lote;
    @NotNull
    private String codigoControle;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;

    @DecimalMin(value = "1.00", inclusive = false)
    @Digits(integer = 9, fraction = 2)
    private Double valorLance;

    private String usuarioLance;

}
