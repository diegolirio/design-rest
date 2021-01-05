package br.com.luizalabs.designrest.veiculos.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class VeiculoLegadoRequest {

    @JsonProperty("OPERACAO")
    private String operacao;

    @JsonProperty("VEICULO")
    private VeiculoLegado veiculo;

}
