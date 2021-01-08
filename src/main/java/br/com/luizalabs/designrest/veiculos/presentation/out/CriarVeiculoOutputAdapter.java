package br.com.luizalabs.designrest.veiculos.presentation.out;

import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CriarVeiculoOutputAdapter implements CriarVeiculoOutputPort {

    private Long id;
    private int lastPage;
}
