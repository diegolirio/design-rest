package br.com.luizalabs.designrest.veiculos.application.excluir;

import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VeiculoExcluirImpl implements VeiculoExcluir {

    private final VeiculoGateway gateway;

    public VeiculoExcluirImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void execute(ExcluirVeiculoInputPort excluirVeiculoInputPort) throws NotFoundException {
        gateway.excluir(excluirVeiculoInputPort.getId());
    }
}
