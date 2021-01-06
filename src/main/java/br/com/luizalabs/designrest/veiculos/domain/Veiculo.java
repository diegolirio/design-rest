package br.com.luizalabs.designrest.veiculos.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Veiculo {

    private Long id;
    private LocalDate dataLance;
    private String lote;
    private String codigoControle;
    private String marca;
    private String modelo;
    private Integer anoFabricacao;
    private Integer anoModelo;
    private Double valorLance;
    private String usuarioLance;

    public void setId(Long id) {
        this.id = id;
    }

    public void setId(String id) {
        try {
            Long idLng = Long.parseLong(id);
            this.id = idLng;
        } catch (Exception ex) {
            throw new RuntimeException("ID deve ser numerico");
        }
    }

}
