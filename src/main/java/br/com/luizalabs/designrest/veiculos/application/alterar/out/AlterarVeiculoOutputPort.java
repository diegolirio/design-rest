package br.com.luizalabs.designrest.veiculos.application.alterar.out;

import java.time.LocalDateTime;

public interface AlterarVeiculoOutputPort {

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
