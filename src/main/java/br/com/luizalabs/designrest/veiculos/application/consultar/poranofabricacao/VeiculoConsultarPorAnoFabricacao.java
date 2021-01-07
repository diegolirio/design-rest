package br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao;

import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.in.ConsultarVeiculoPorAnoFabricacaoInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultarPorAnoFabricacao {

    List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorAnoFabricacaoInputPort inputPort);
}
