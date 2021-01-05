package br.com.luizalabs.designrest.veiculos.application;

import br.com.luizalabs.designrest.veiculos.application.in.CriarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.out.CriarVeiculoOutputPort;

public interface VeiculoCriar {

    CriarVeiculoOutputPort execute(CriarVeiculoInputPort UsecaseCriarVeiculoInputPort);
}
