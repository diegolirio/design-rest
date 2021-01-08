package br.com.luizalabs.designrest.veiculos.application.alterar;

import br.com.luizalabs.designrest.veiculos.application.alterar.in.AlterarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.exceptions.NotFoundException;

public interface VeiculoAlterar {

    AlterarVeiculoOutputPort execute(AlterarVeiculoInputPort alterarVeiculoInputPort, String id) throws NotFoundException;
}
