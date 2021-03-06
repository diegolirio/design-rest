package br.com.luizalabs.designrest.veiculos.application.criar;

import br.com.luizalabs.designrest.veiculos.application.criar.in.CriarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.CriarVeiculoOutputAdapter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import static br.com.luizalabs.designrest.veiculos.application.criar.mapper.VeiculoUsecasePortMapper.mapper;

@Service
public class VeiculoCriarImpl implements VeiculoCriar {

    private final VeiculoGateway gateway;

    public VeiculoCriarImpl(VeiculoGateway gateway) { this.gateway = gateway; }

    @SneakyThrows
    @Override
    public CriarVeiculoOutputPort execute(CriarVeiculoInputPort criarVeiculoInputPort) {
        Veiculo veiculo = mapper.map(criarVeiculoInputPort);
        CriarVeiculoOutputAdapter criarVeiculoOutputAdapter = mapper.mapOutput(gateway.criar(veiculo));
        criarVeiculoOutputAdapter.setLastPage(gateway.count() / 10);
        return criarVeiculoOutputAdapter;
    }
}
