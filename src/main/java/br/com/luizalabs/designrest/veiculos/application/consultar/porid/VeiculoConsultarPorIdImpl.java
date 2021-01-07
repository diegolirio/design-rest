package br.com.luizalabs.designrest.veiculos.application.consultar.porid;

import br.com.luizalabs.designrest.veiculos.application.consultar.porid.in.ConsultarVeiculoPorIdInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.mapper.VeiculoConsultarPorIdUsecasePortMapper;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.domain.VeiculoGateway;
import org.springframework.stereotype.Service;

@Service
public class VeiculoConsultarPorIdImpl implements VeiculoConsultarPorId {

    private final VeiculoGateway gateway;

    public VeiculoConsultarPorIdImpl(VeiculoGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public ConsultarVeiculoPorIdOutputPort execute(ConsultarVeiculoPorIdInputPort inputPort) {
        Veiculo veiculo = this.gateway.consultarPorId(inputPort.getId());
        return VeiculoConsultarPorIdUsecasePortMapper.mapper.mapOutput(veiculo);

    }
}
