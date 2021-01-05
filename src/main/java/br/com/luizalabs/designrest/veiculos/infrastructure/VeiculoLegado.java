package br.com.luizalabs.designrest.veiculos.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VeiculoLegado {

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("DATALANCE")
    private String DATALANCE;

    @JsonProperty("LOTE")
    private String LOTE;

    @JsonProperty("CODIGOCONTROLE")
    private String CODIGOCONTROLE;

    @JsonProperty("MARCA")
    private String MARCA;

    @JsonProperty("MODELO")
    private String MODELO;

    @JsonProperty("ANOFABRICACAO")
    private Integer ANOFABRICACAO;

    @JsonProperty("ANOMODELO")
    private Integer ANOMODELO;

    @JsonProperty("VALORLANCE")
    private Double VALORLANCE;

    @JsonProperty("USUARIOLANCE")
    private String USUARIOLANCE;
}