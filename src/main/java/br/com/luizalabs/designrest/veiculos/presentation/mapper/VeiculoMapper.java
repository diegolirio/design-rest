package br.com.luizalabs.designrest.veiculos.presentation.mapper;

import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.VeiculoController;
import org.springframework.hateoas.server.mvc.ControllerLinkRelationProvider;
import br.com.luizalabs.designrest.veiculos.presentation.in.AlterarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.CriarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.ExcluirVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoMapper {

    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    CriarVeiculoInputAdapter mapInputCriar(VeiculoResource veiculoResource);

    AlterarVeiculoInputAdapter mapInputAlterar(VeiculoResource veiculoResource);

    VeiculoResourceID mapOut(CriarVeiculoOutputPort outputPort);

    VeiculoResource mapOutAlterar(AlterarVeiculoOutputPort outputPort);

    VeiculoResource mapOut(ConsultarVeiculoPorIdOutputPort outputPort);

    ExcluirVeiculoInputAdapter mapInputExcluir(ExcluirVeiculoInputPort inputPort);

    List<VeiculoResource> mapOut(List<ConsultarVeiculoOutputAdapter> outputPort);

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoResource veiculoResource, ConsultarVeiculoPorIdOutputPort adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoResource veiculoResource, ConsultarVeiculoOutputAdapter adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoResourceID veiculoResourceID, CriarVeiculoOutputPort adapter) {
        veiculoResourceID.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResourceID.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }

    @AfterMapping
    default void addLinks(@MappingTarget VeiculoResource veiculoResource, AlterarVeiculoOutputPort adapter) {
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarPorId(adapter.getId())).withRel("Self") );
        veiculoResource.add( WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VeiculoController.class).consultarTodos(0, 10)).withRel("list") );
    }
}
