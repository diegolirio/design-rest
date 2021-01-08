package br.com.luizalabs.designrest.veiculos.infrastructure;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VeiculoLegado {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("DATALANCE")
    private String dataLance;

    @JsonProperty("LOTE")
    private String lote;

    @JsonProperty("CODIGOCONTROLE")
    private String codigoControle;

    @JsonProperty("MARCA")
    private String marca;

    @JsonProperty("MODELO")
    private String modelo;

    @JsonProperty("ANOFABRICACAO")
    private Integer anoFabricao;

    @JsonProperty("ANOMODELO")
    private Integer anoModelo;

    @JsonProperty("VALORLANCE")
    private Double valorLance;

    @JsonProperty("USUARIOLANCE")
    private String usuarioLance;

    @JsonIgnoreProperties
    private int lastPage;
}