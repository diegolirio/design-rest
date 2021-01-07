package br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao;

import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.in.ConsultarVeiculoPorAnoFabricacaoInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.mapper.VeiculoConsultarPorMarcaUsecasePortMapper.mapper;

@Service
public class VeiculoConsultarPorAnoFabricacaoImpl implements VeiculoConsultarPorAnoFabricacao {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorAnoFabricacaoImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorAnoFabricacaoInputPort inputPort) {
        List<Veiculo> veiculos = this.gateway.consultar();
        List<Veiculo> veiculosFilter =
                veiculos.stream()
                        .filter(v -> v.getAnoFabricacao() != null &&
                                v.getAnoFabricacao().intValue() >= inputPort.getAnoInicio().intValue() &&
                                v.getAnoFabricacao().intValue() <= inputPort.getAnoFim().intValue())
                        .collect(Collectors.toList());
        return mapper.mapOutput(Veiculo.paginaSubLista(veiculosFilter, inputPort.getOffset(), inputPort.getLimit()));
    }
}
