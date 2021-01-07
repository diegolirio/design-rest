package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.in.ConsultarVeiculoPorModeloInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorModeloInputAdapter implements ConsultarVeiculoPorModeloInputPort {

    private String modelo;
    private Integer offset;
    private Integer limit;
}
