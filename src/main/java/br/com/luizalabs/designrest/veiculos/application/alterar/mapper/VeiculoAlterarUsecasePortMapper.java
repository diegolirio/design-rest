package br.com.luizalabs.designrest.veiculos.application.alterar.mapper;

import br.com.luizalabs.designrest.veiculos.application.alterar.in.AlterarVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.presentation.out.AlterarVeiculoOutputAdapter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VeiculoAlterarUsecasePortMapper {

    VeiculoAlterarUsecasePortMapper mapper = Mappers.getMapper(VeiculoAlterarUsecasePortMapper.class);

    Veiculo map(AlterarVeiculoInputPort alterarVeiculoInputPort);

    AlterarVeiculoOutputAdapter mapOutput(Veiculo veiculo);
}
