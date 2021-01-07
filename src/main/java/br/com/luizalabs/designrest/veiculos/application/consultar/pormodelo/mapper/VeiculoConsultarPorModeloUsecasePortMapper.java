package br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoConsultarPorModeloUsecasePortMapper {

    VeiculoConsultarPorModeloUsecasePortMapper mapper = Mappers.getMapper(VeiculoConsultarPorModeloUsecasePortMapper.class);

    ConsultarVeiculoOutputAdapter mapOutput(Veiculo veiculo);

    List<ConsultarVeiculoOutputAdapter> mapOutput(List<Veiculo> veiculo);
}
