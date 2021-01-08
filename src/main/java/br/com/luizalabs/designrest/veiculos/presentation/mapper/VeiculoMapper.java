package br.com.luizalabs.designrest.veiculos.presentation.mapper;

import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.VeiculoController;
import br.com.luizalabs.designrest.veiculos.presentation.in.AlterarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.CriarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.ExcluirVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoInputResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoOutputResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    CriarVeiculoInputAdapter mapInputCriar(VeiculoInputResource veiculoResource);

    AlterarVeiculoInputAdapter mapInputAlterar(VeiculoInputResource veiculoResource);

    VeiculoResourceID mapOut(CriarVeiculoOutputPort outputPort);

    VeiculoOutputResource mapOutAlterar(AlterarVeiculoOutputPort outputPort);

    VeiculoOutputResource mapOut(ConsultarVeiculoPorIdOutputPort outputPort);

    ExcluirVeiculoInputAdapter mapInputExcluir(ExcluirVeiculoInputPort inputPort);

    List<VeiculoOutputResource> mapOut(List<ConsultarVeiculoOutputAdapter> outputPort);

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoOutputResource veiculoResource, ConsultarVeiculoPorIdOutputPort adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoOutputResource veiculoResource, ConsultarVeiculoOutputAdapter adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoResourceID veiculoResourceID, CriarVeiculoOutputPort adapter) {
        veiculoResourceID.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResourceID.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoOutputResource veiculoResource, AlterarVeiculoOutputPort adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }
}
