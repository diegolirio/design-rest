package br.com.luizalabs.designrest.veiculos.application.consultar.pormarca;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.in.ConsultarVeiculoPorMarcaInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultarPorMarca {

    List<ConsultarVeiculoOutputAdapter> execute(ConsultarVeiculoPorMarcaInputPort inputPort);
}
