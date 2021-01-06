package br.com.luizalabs.designrest.veiculos.application.consultar;

import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultar {

    List<ConsultarVeiculoOutputAdapter> execute();
    // TODO 1 - Fora ou lista dentro do Objeto ?  ***  2 - Adapter dentro de Application
}
