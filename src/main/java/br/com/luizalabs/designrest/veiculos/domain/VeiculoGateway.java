package br.com.luizalabs.designrest.veiculos.domain;

import java.util.List;

public interface VeiculoGateway {

    Veiculo criar(Veiculo veiculo);

    Veiculo alterar(Veiculo veiculo);

    void excluir(Long id);

    List<Veiculo> consultar();

    Veiculo consultarPorId(Long id);
}
