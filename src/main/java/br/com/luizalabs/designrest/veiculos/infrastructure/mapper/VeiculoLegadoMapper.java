package br.com.luizalabs.designrest.veiculos.infrastructure.mapper;

import br.com.luizalabs.designrest.veiculos.domain.Veiculo;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegado;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegadoRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public abstract class VeiculoLegadoMapper {

    public static VeiculoLegadoMapper mapper = Mappers.getMapper(VeiculoLegadoMapper.class);
    private static final String DATE_FORMTAER = "dd/MM/yyyy";

    public VeiculoLegadoRequest map(Veiculo veiculo) {
        VeiculoLegado veiculoLegado = getVeiculoLegado(veiculo);
        return VeiculoLegadoRequest.builder().veiculo(veiculoLegado).build();
    }

    public Veiculo mapDomain(VeiculoLegado veiculoLegado) {
        Veiculo veiculo = new Veiculo();
        veiculo.setAnoFabricacao(veiculoLegado.getAnoFabricao());
        veiculo.setAnoModelo(veiculoLegado.getAnoModelo());
        veiculo.setCodigoControle(veiculoLegado.getCodigoControle());
        veiculo.setDataLance(LocalDate.parse(veiculoLegado.getDataLance(), DateTimeFormatter.ofPattern(DATE_FORMTAER)));
        veiculo.setLote(veiculoLegado.getLote());
        veiculo.setMarca(veiculoLegado.getMarca());
        veiculo.setId(veiculoLegado.getId());
        return veiculo;
    }

    private VeiculoLegado getVeiculoLegado(Veiculo veiculo) {
        VeiculoLegado veiculoLegado =
                VeiculoLegado.builder()
                        .anoFabricao(veiculo.getAnoFabricacao())
                        .anoModelo(veiculo.getAnoModelo())
                        .codigoControle(veiculo.getCodigoControle())
                        .dataLance(veiculo.getDataLance().format(DateTimeFormatter.ofPattern(DATE_FORMTAER)))
                        .lote(veiculo.getLote())
                        .marca(veiculo.getMarca())
                        .modelo(veiculo.getModelo())
                        .usuarioLance(veiculo.getUsuarioLance())
                        .valorLance(veiculo.getValorLance())
                        .id(veiculo.getId())
                        .build();
        return veiculoLegado;
    }
}
