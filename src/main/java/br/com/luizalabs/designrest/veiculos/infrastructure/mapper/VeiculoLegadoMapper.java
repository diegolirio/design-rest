package br.com.luizalabs.designrest.veiculos.infrastructure.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegado;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegadoRequest;
import org.mapstruct.factory.Mappers;

public interface VeiculoLegadoMapper {

    VeiculoLegadoMapper mapper = Mappers.getMapper(VeiculoLegadoMapper.class);

    VeiculoLegadoRequest map(Veiculo veiculo);
    Veiculo mapDomain(VeiculoLegado veiculoLegado);
}
