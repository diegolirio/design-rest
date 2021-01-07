package br.com.luizalabs.designrest.veiculos.application.alterar.in;

import java.time.LocalDateTime;

public interface AlterarVeiculoInputPort {

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
