package br.com.luizalabs.designrest.veiculos.application;

import br.com.luizalabs.designrest.veiculos.application.in.CriarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import org.springframework.stereotype.Service;

import static br.com.luizalabs.designrest.veiculos.application.mapper.VeiculoUsecasePortMapper.mapper;

@Service
public class VeiculoCriarImpl implements VeiculoCriar {

    private final VeiculoGateway gateway;

    public VeiculoCriarImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public CriarVeiculoOutputPort execute(CriarVeiculoInputPort criarVeiculoInputPort) {
        Veiculo veiculo = mapper.map(criarVeiculoInputPort);
        return mapper.mapOutput(gateway.criar(veiculo));
    }
}
