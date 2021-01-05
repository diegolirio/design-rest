package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.in.CriarVeiculoInputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CriarVeiculoInputAdapter implements CriarVeiculoInputPort {

    private LocalDateTime dateLaunch;
    private String lote;
    private String codigoControle;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Double valorLance;
    private String usuarioLance;
}
