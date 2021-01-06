package br.com.luizalabs.designrest.veiculos.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "veiculoClient", url = "${services.veiculo.legado.url}")
interface VeiculoClient {

    @PostMapping
    VeiculoLegado postVeiculo(@RequestBody VeiculoLegadoRequest veiculoLegado);

    @PostMapping
    List<VeiculoLegado> postVeiculoListAll(@RequestBody VeiculoLegadoRequest veiculoLegado);
}
