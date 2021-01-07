package br.com.luizalabs.designrest.veiculos.application.consultar.porid.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoConsultarPorIdUsecasePortMapper {

    VeiculoConsultarPorIdUsecasePortMapper mapper = Mappers.getMapper(VeiculoConsultarPorIdUsecasePortMapper.class);

    ConsultarVeiculoOutputAdapter mapOutput(Veiculo veiculo);
}
