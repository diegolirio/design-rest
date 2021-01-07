package br.com.luizalabs.designrest.veiculos.application.consultar.todos.out;

import java.time.LocalDateTime;

public interface ConsultarVeiculoOutputPort {

    Long getId();

    LocalDateTime getDataLance();

    String getLote();

    String getCodigoControle();

    String getMarca();

    String getModelo();

    Integer getAnoFabricacao();

    Integer getAnoModelo();

    Double getValorLance();

    String getUsuarioLance();

}
