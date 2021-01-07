package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.in.ConsultarVeiculoPorAnoFabricacaoInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorAnoFabricacaoInputAdapter implements ConsultarVeiculoPorAnoFabricacaoInputPort {

    private Integer anoInicio;
    private Integer anoFim;
    private Integer offset;
    private Integer limit;

}
