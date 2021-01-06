package br.com.luizalabs.designrest.veiculos.presentation.mapper;

import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.presentation.in.AlterarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.CriarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoMapper mapper = Mappers.getMapper(VeiculoMapper.class);

    CriarVeiculoInputAdapter mapInputCriar(VeiculoResource veiculoResource);

    AlterarVeiculoInputAdapter mapInputAlterar(VeiculoResource veiculoResource);

    VeiculoResourceID mapOut(CriarVeiculoOutputPort outputPort);

    VeiculoResource mapOutAlterar(AlterarVeiculoOutputPort outputPort);
}
