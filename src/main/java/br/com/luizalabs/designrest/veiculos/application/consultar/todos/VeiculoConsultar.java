package br.com.luizalabs.designrest.veiculos.application.consultar.todos;

import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;

import java.util.List;

public interface VeiculoConsultar {

    List<ConsultarVeiculoOutputAdapter> execute();
}
