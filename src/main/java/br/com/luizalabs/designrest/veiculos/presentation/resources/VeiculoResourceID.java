package br.com.luizalabs.designrest.veiculos.presentation.resources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

@Getter
@Setter
public class VeiculoResourceID extends RepresentationModel {

    private Long id;
}
