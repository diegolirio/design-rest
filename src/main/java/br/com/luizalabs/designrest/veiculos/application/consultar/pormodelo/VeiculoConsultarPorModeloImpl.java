package br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.in.ConsultarVeiculoPorModeloInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.mapper.VeiculoConsultarPorMarcaUsecasePortMapper.mapper;

@Service
public class VeiculoConsultarPorModeloImpl implements VeiculoConsultarPorModelo {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorModeloImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorModeloInputPort inputPort) {
        List<Veiculo> veiculos = this.gateway.consultar();
        List<Veiculo> veiculosFilter =
                veiculos.stream()
                        .filter(v -> v.getModelo() != null && v.getModelo().toLowerCase().startsWith(inputPort.getModelo().toLowerCase()))
                        .collect(Collectors.toList());
        return mapper.mapOutput(veiculosFilter);
    }
}
