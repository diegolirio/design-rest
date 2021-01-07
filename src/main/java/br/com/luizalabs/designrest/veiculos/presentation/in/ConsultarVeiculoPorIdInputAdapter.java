package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.porid.in.ConsultarVeiculoPorIdInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorIdInputAdapter implements ConsultarVeiculoPorIdInputPort {

    private Long id;
}
