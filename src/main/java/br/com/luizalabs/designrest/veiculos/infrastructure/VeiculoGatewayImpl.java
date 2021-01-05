package br.com.luizalabs.designrest.veiculos.infrastructure;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.luizalabs.designrest.veiculos.infrastructure.mapper.VeiculoLegadoMapper.mapper;

@Service
@AllArgsConstructor
public class VeiculoGatewayImpl implements VeiculoGateway {

    private final VeiculoClient veiculoClient;

    @Override
    public Veiculo criar(Veiculo veiculo) {
        VeiculoLegadoRequest veiculoLegadoRequest = mapper.map(veiculo); // TODO to Legado
        VeiculoLegado veiculoLegado = this.veiculoClient.postVeiculo(veiculoLegadoRequest);
        return mapper.mapDomain(veiculoLegado); // TODO to Domain
    }
}
