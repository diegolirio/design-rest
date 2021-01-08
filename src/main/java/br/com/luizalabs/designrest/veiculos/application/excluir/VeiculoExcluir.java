package br.com.luizalabs.designrest.veiculos.application.excluir;

import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.exceptions.NotFoundException;

public interface VeiculoExcluir {

    void execute(ExcluirVeiculoInputPort excluirVeiculoInputPort) throws NotFoundException;
}
