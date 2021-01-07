package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.alterar.in.AlterarVeiculoInputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AlterarVeiculoInputAdapter implements AlterarVeiculoInputPort {

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
