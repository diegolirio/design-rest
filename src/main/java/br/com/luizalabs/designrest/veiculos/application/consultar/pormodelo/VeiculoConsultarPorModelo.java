package br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.in.ConsultarVeiculoPorModeloInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultarPorModelo {

    List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorModeloInputPort inputPort);
}
