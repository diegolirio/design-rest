package br.com.luizalabs.designrest.veiculos.domain;

import br.com.luizalabs.designrest.veiculos.exceptions.NotFoundException;

import java.util.List;

public interface VeiculoGateway {

    Veiculo criar(Veiculo veiculo) throws NotFoundException;

    Veiculo alterar(Veiculo veiculo) throws NotFoundException;

    void excluir(Long id) throws NotFoundException;

    List<Veiculo> consultar();

    Veiculo consultarPorId(Long id);

    int count();
}
