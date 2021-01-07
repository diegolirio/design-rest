package br.com.luizalabs.designrest.veiculos.application.consultar.porid;

import br.com.luizalabs.designrest.veiculos.application.consultar.porid.in.ConsultarVeiculoPorIdInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;

public interface VeiculoConsultarPorId {

    ConsultarVeiculoPorIdOutputPort execute(ConsultarVeiculoPorIdInputPort inputPort);
}
