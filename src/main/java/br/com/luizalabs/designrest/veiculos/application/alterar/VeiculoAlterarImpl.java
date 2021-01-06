package br.com.luizalabs.designrest.veiculos.application.alterar;

import br.com.luizalabs.designrest.veiculos.application.alterar.in.AlterarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import org.springframework.stereotype.Service;

import static br.com.luizalabs.designrest.veiculos.application.alterar.mapper.VeiculoAlterarUsecasePortMapper.mapper;

@Service
public class VeiculoAlterarImpl implements VeiculoAlterar {

    private final VeiculoGateway gateway;

    public VeiculoAlterarImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public AlterarVeiculoOutputPort execute(AlterarVeiculoInputPort alterarVeiculoInputPort, String id) {
        Veiculo veiculo = mapper.map(alterarVeiculoInputPort);
        veiculo.setId(Long.parseLong(id));
        return mapper.mapOutput(gateway.alterar(veiculo));
    }
}
