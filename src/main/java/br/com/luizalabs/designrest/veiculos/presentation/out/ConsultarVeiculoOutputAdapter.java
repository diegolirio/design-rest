package br.com.luizalabs.designrest.veiculos.presentation.out;

import br.com.luizalabs.designrest.veiculos.application.consultar.todos.out.ConsultarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porano.out.ConsultarVeiculoPorAnoFabricacaoAnoModeloOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.out.ConsultarVeiculoPorAnoFabricacaoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.out.ConsultarVeiculoPorLoteOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.out.ConsultarVeiculoPorMarcaOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.out.ConsultarVeiculoPorModeloOutputPort;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultarVeiculoOutputAdapter implements ConsultarVeiculoOutputPort, ConsultarVeiculoPorIdOutputPort,
                                                      ConsultarVeiculoPorLoteOutputPort, ConsultarVeiculoPorMarcaOutputPort,
                                                      ConsultarVeiculoPorModeloOutputPort, ConsultarVeiculoPorAnoFabricacaoAnoModeloOutputPort,
                                                      ConsultarVeiculoPorAnoFabricacaoOutputPort {

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

    private Integer total;
    private Integer firstPage;
    private Integer lastPage;
}
