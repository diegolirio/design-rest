package br.com.luizalabs.designrest.veiculos.infrastructure;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.infrastructure.mapper.VeiculoLegadoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VeiculoGatewayImpl implements VeiculoGateway {

    private final VeiculoClient veiculoClient;

    @Override
    public Veiculo criar(Veiculo veiculo) {
        VeiculoLegadoRequest veiculoLegadoRequest = VeiculoLegadoMapper.mapper.map(veiculo);
        veiculoLegadoRequest.setOperacao("criar");
        VeiculoLegado veiculoLegado = this.veiculoClient.postVeiculo(veiculoLegadoRequest);
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegado);
    }

    @Override
    public Veiculo alterar(Veiculo veiculo) {
        VeiculoLegadoRequest veiculoLegadoRequest = VeiculoLegadoMapper.mapper.map(veiculo);
        veiculoLegadoRequest.setOperacao("alterar");
        VeiculoLegado veiculoLegado = this.veiculoClient.postVeiculo(veiculoLegadoRequest);
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegado);
    }
}
