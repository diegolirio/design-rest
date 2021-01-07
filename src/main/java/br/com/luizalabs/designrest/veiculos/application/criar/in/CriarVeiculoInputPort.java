package br.com.luizalabs.designrest.veiculos.application.criar.in;

import java.time.LocalDateTime;

public interface CriarVeiculoInputPort {

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
