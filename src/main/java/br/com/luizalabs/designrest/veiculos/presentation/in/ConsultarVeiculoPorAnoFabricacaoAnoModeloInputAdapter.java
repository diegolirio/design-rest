package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.porano.in.ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorAnoFabricacaoAnoModeloInputAdapter implements ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort {

    private Integer anoFabricacao;
    private Integer anoModelo;

}
