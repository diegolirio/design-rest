package br.com.luizalabs.designrest.veiculos.domain;

public interface VeiculoGateway {

    Veiculo criar(Veiculo veiculo);

    Veiculo alterar(Veiculo veiculo);
}
