package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExcluirVeiculoInputAdapter implements ExcluirVeiculoInputPort {

    private Long id;
}
