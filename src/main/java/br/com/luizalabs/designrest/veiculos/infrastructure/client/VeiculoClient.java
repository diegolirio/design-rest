package br.com.luizalabs.designrest.veiculos.infrastructure.client;

import br.com.luizalabs.designrest.veiculos.exceptions.NotFoundException;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegado;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegadoRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(name = "veiculoClient", url = "${services.veiculo.legado.url}")
public interface VeiculoClient {

    //@PostMapping
    VeiculoLegado postVeiculo(@RequestBody VeiculoLegadoRequest veiculoLegado) throws NotFoundException;

    //@PostMapping
    List<VeiculoLegado> postVeiculoListAll(@RequestBody VeiculoLegadoRequest veiculoLegado);
}
