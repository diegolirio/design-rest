package br.com.luizalabs.designrest.veiculos.application.consultar.porano.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoConsultarPorAnoFabrModeloUsecasePortMapper {

    VeiculoConsultarPorAnoFabrModeloUsecasePortMapper mapper = Mappers.getMapper(VeiculoConsultarPorAnoFabrModeloUsecasePortMapper.class);

    ConsultarVeiculoOutputAdapter mapOutput(Veiculo veiculo);
    List<ConsultarVeiculoOutputAdapter> mapOutput(List<Veiculo> veiculo);
}
