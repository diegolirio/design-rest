package br.com.luizalabs.designrest.veiculos.presentation.out;

import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class AlterarVeiculoOutputAdapter implements AlterarVeiculoOutputPort {

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
    private int lastPage;
}
