package br.com.luizalabs.designrest.veiculos.application.consultar.porlote.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VeiculoConsultarPorLoteUsecasePortMapper {

    VeiculoConsultarPorLoteUsecasePortMapper mapper = Mappers.getMapper(VeiculoConsultarPorLoteUsecasePortMapper.class);

    ConsultarVeiculoOutputAdapter mapOutputLote(Veiculo veiculo);
    List<ConsultarVeiculoOutputAdapter> mapOutputLote(List<Veiculo> veiculo);
}
