package br.com.luizalabs.designrest.veiculos.application.alterar;

import br.com.luizalabs.designrest.veiculos.application.alterar.in.AlterarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;

public interface VeiculoAlterar {

    AlterarVeiculoOutputPort execute(AlterarVeiculoInputPort alterarVeiculoInputPort, String id);
}
