package br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoConsultarPorAnoFabricacaoUsecasePortMapper {

    VeiculoConsultarPorAnoFabricacaoUsecasePortMapper mapper = Mappers.getMapper(VeiculoConsultarPorAnoFabricacaoUsecasePortMapper.class);

    ConsultarVeiculoOutputAdapter mapOutput(Veiculo veiculo);

    List<ConsultarVeiculoOutputAdapter> mapOutput(List<Veiculo> veiculo);
}
