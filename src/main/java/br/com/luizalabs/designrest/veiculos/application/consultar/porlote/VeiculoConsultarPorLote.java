package br.com.luizalabs.designrest.veiculos.application.consultar.porlote;

import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.in.ConsultarVeiculoPorLoteInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultarPorLote {

    List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorLoteInputPort inputPort);
}
