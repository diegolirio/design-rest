package br.com.luizalabs.designrest.veiculos.application.consultar.out;

import java.time.LocalDate;

public interface ConsultarVeiculoOutputPort {

    Long getId();
    LocalDate getDataLance();
    String getLote();
    String getCodigoControle();
    String getMarca();
    String getModelo();
    Integer getAnoFabricacao();
    Integer getAnoModelo();
    Double getValorLance();
    String getUsuarioLance();

}
