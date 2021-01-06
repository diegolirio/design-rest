package br.com.luizalabs.designrest.veiculos.application.criar.in;

import java.time.LocalDate;

public interface CriarVeiculoInputPort {

    LocalDate getDataLance(); // "DATALANCE": "04/01/2020 - 21:51",

    String getLote(); // "LOTE": "0258",

    String getCodigoControle(); // "CODIGOCONTROLE": "56254",

    String getMarca();  // "MARCA": "Tesla",

    String getModelo(); //"MODELO": "Model X",

    Integer getAnoFabricacao(); // "ANOFABRICACAO": 2016,

    Integer getAnoModelo(); // "ANOMODELO": 2016,

    Double getValorLance(); //"VALORLANCE": 350000,

    String getUsuarioLance(); //"USUARIOLANCE": "-"

}
