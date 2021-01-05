package br.com.luizalabs.designrest.veiculos.presentation.resources;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class VeiculoResource {

    private Long id;
    private LocalDateTime dataLance;
    private String lote;
    private String codigoControle;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Double valorLance;
    private String usuarioLance;

}
