package br.com.luizalabs.designrest.veiculos.infrastructure;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.infrastructure.mapper.VeiculoLegadoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeiculoGatewayImpl implements VeiculoGateway {

    public static final String CRIAR = "criar";
    public static final String ALTERAR = "alterar";
    public static final String EXCLUIR = "excluir";
    private static final String CONSULTAR = "consultar";

    private final VeiculoClient veiculoClient;

    @Override
    public Veiculo criar(Veiculo veiculo) {
        VeiculoLegadoRequest veiculoLegadoRequest = VeiculoLegadoMapper.mapper.map(veiculo);
        veiculoLegadoRequest.setOperacao(CRIAR);
        VeiculoLegado veiculoLegado = this.veiculoClient.postVeiculo(veiculoLegadoRequest);
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegado);
    }

    @Override
    public Veiculo alterar(Veiculo veiculo) {
        VeiculoLegadoRequest veiculoLegadoRequest = VeiculoLegadoMapper.mapper.map(veiculo);
        veiculoLegadoRequest.setOperacao(ALTERAR);
        VeiculoLegado veiculoLegado = this.veiculoClient.postVeiculo(veiculoLegadoRequest);
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegado);
    }

    @Override
    public void excluir(Long id) {
        VeiculoLegadoRequest veiculoLegadoRequest =
                VeiculoLegadoRequest.builder()
                                    .operacao(EXCLUIR)
                                    .veiculo(VeiculoLegado.builder().id(id).build())
                                    .build();
        this.veiculoClient.postVeiculo(veiculoLegadoRequest);
    }

    @Override
    public List<Veiculo> consultar() {
        VeiculoLegadoRequest veiculoLegadoRequest =
                VeiculoLegadoRequest.builder()
                        .operacao(CONSULTAR)
                        .build();
        List<VeiculoLegado> veiculoLegados = this.veiculoClient.postVeiculoListAll(veiculoLegadoRequest);
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegados);
    }

    @Override
    public Veiculo consultarPorId(Long id) {
        VeiculoLegadoRequest veiculoLegadoRequest =
                VeiculoLegadoRequest.builder()
                        .operacao(CONSULTAR)
                        .build();
        List<VeiculoLegado> veiculoLegados = this.veiculoClient.postVeiculoListAll(veiculoLegadoRequest);
        VeiculoLegado veiculoLegado =
                veiculoLegados.stream()
                              .filter(v -> v.getId() != null && v.getId().equals(id))
                              .findFirst().get();
        return VeiculoLegadoMapper.mapper.mapDomain(veiculoLegado);
    }
}
