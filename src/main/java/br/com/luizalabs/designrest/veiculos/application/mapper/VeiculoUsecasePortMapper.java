package br.com.luizalabs.designrest.veiculos.application.mapper;

import br.com.luizalabs.designrest.veiculos.application.in.CriarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.CriarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoUsecasePortMapper {

    VeiculoUsecasePortMapper mapper = Mappers.getMapper(VeiculoUsecasePortMapper.class);

    Veiculo map(CriarVeiculoInputPort criarVeiculoInputPort);

    CriarVeiculoOutputAdapter mapOutput(Veiculo criar);
}
