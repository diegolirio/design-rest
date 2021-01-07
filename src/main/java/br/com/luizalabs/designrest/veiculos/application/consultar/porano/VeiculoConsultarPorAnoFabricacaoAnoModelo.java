package br.com.luizalabs.designrest.veiculos.application.consultar.porano;

import br.com.luizalabs.designrest.veiculos.application.consultar.porano.in.ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultarPorAnoFabricacaoAnoModelo {

    List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort inputPort);
}
