package br.com.luizalabs.designrest.veiculos.application.consultar.todos;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.luizalabs.designrest.veiculos.application.consultar.todos.mapper.VeiculoConsultarUsecasePortMapper.mapper;

@Service
public class VeiculoConsultarImpl implements VeiculoConsultar {

    private final VeiculoGateway gateway;

    public VeiculoConsultarImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<ConsultarVeiculoOutputAdapter> execute() {
        List<Veiculo> veiculos = this.gateway.consultar();
        return mapper.mapOutput(veiculos);
    }
}
