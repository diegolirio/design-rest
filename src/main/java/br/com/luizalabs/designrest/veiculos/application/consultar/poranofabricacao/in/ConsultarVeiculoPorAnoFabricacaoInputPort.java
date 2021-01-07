package br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.in;

public interface ConsultarVeiculoPorAnoFabricacaoInputPort {

    Integer getAnoInicio();
    Integer getAnoFim();
    Integer getOffset();
    Integer getLimit();

}
