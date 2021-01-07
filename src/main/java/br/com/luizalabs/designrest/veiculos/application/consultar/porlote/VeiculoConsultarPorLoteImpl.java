package br.com.luizalabs.designrest.veiculos.application.consultar.porlote;

import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.mapper.VeiculoConsultarPorLoteUsecasePortMapper;
import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.in.ConsultarVeiculoPorLoteInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoConsultarPorLoteImpl implements VeiculoConsultarPorLote {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorLoteImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorLoteInputPort inputPort) {
        List<Veiculo> veiculos = this.gateway.consultar();
        List<Veiculo> veiculosPorLote = veiculos.stream().filter(v -> v.getLote().equals(inputPort.getLote())).collect(Collectors.toList());
        return VeiculoConsultarPorLoteUsecasePortMapper.mapper.mapOutputLote(veiculosPorLote);
    }
}
