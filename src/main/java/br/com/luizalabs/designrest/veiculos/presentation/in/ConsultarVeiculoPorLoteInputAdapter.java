package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.in.ConsultarVeiculoPorLoteInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorLoteInputAdapter implements ConsultarVeiculoPorLoteInputPort {

    private String lote;
}
