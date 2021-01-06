package br.com.luizalabs.designrest.veiculos.application.criar;

import br.com.luizalabs.designrest.veiculos.application.criar.in.CriarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;

public interface VeiculoCriar {

    CriarVeiculoOutputPort execute(CriarVeiculoInputPort UsecaseCriarVeiculoInputPort);
}
