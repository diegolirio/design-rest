package br.com.luizalabs.designrest.veiculos.presentation.in;

import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.in.ConsultarVeiculoPorMarcaInputPort;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultarVeiculoPorMarcaInputAdapter implements ConsultarVeiculoPorMarcaInputPort {

    private String marca;

}
