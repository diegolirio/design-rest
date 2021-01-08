package br.com.luizalabs.designrest.veiculos.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Veiculo {

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

    public static List<Veiculo> paginaSubLista(List<Veiculo> veiculos, Integer page, Integer size) {
        try {
            if (veiculos.size() - page >= size) {
                return veiculos.subList(page*size, (page+1) * size);
            }
            return veiculos.subList(page, veiculos.size());
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }

}
