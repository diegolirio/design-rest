package br.com.luizalabs.designrest.veiculos.application.consultar.porano;

import br.com.luizalabs.designrest.veiculos.application.consultar.porano.in.ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.mapper.VeiculoConsultarPorMarcaUsecasePortMapper.mapper;

@Service
public class VeiculoConsultarPorAnoFabricacaoAnoModeloImpl implements VeiculoConsultarPorAnoFabricacaoAnoModelo {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorAnoFabricacaoAnoModeloImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort inputPort) {
        List<Veiculo> veiculos = this.gateway.consultar();
        List<Veiculo> veiculosFilter =
                veiculos.stream()
                        .filter(v -> v.getAnoFabricacao() != null && v.getAnoModelo() != null &&
                                v.getAnoFabricacao().equals(inputPort.getAnoFabricacao()) &&
                                v.getAnoModelo().equals(inputPort.getAnoModelo()))
                        .collect(Collectors.toList());
        return mapper.mapOutput(Veiculo.paginaSubLista(veiculosFilter, inputPort.getOffset(), inputPort.getLimit()));
    }
}
