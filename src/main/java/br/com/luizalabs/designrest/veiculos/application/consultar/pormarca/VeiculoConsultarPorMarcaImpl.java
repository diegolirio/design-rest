package br.com.luizalabs.designrest.veiculos.application.consultar.pormarca;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.mapper.VeiculoConsultarPorMarcaUsecasePortMapper;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.in.ConsultarVeiculoPorMarcaInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoConsultarPorMarcaImpl implements VeiculoConsultarPorMarca {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorMarcaImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorMarcaInputPort inputPort) {
        List<Veiculo> veiculos = this.gateway.consultar();
        List<Veiculo> veiculosFilter = veiculos.stream().filter(v -> v.getMarca().equals(inputPort.getMarca())).collect(Collectors.toList());
        return VeiculoConsultarPorMarcaUsecasePortMapper.mapper.mapOutput(veiculosFilter);
    }
}
