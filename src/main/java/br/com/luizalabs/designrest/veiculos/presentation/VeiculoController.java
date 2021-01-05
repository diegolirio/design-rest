package br.com.luizalabs.designrest.veiculos.presentation;

import br.com.luizalabs.designrest.veiculos.application.VeiculoCriar;
import br.com.luizalabs.designrest.veiculos.application.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.presentation.in.CriarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static br.com.luizalabs.designrest.veiculos.presentation.VeiculoController.VEICULOS_PREFIX_URL;
import static br.com.luizalabs.designrest.veiculos.presentation.mapper.VeiculoMapper.mapper;

@AllArgsConstructor
@RestController
@RequestMapping(VEICULOS_PREFIX_URL)
public class VeiculoController {

    public static final String VEICULOS_PREFIX_URL = "/v1/veiculos";
    private final VeiculoCriar veiculoCriar;

    @GetMapping
    public List<VeiculoResource> getAll() {
        // TODO 4 busca todos,
        //    6 busca por lote,
        //    7 busca por marca,
        //    8 busca por iniciais do modelo,
        //    9 busca veiculos por anoFabr/AnoModelo,
        //    10 busca between ano de fabr
        return List.of(new VeiculoResource());
    }

    @GetMapping("/{id}")
    public VeiculoResource getById(@PathVariable Long id) {
        return new VeiculoResource();
    }

    @PostMapping
    public VeiculoResourceID create(@RequestBody VeiculoResource veiculoResource) {
        CriarVeiculoInputAdapter inputAdapter = mapper.mapInput(veiculoResource);
        CriarVeiculoOutputPort outputPort = veiculoCriar.execute(inputAdapter);
        return mapper.mapOut(outputPort);
    }

    @PutMapping("/{id}")
    public VeiculoResource update(@PathVariable Long id, @RequestBody VeiculoResource veiculoResource) {
        /*
            "ID": 9999,
            "DATALANCE": "21/08/2020 - 13:24",
            "LOTE": "0196",
            "CODIGOCONTROLE": "56248",
            "MARCA": "RENAULT",
            "MODELO": "CLIO 16VS",
            "ANOFABRICACAO": 2007,
            "ANOMODELO": 2007,
            "VALORLANCE": 0,
            "USUARIOLANCE": "-"
         */
        veiculoResource.setId(id);
        return veiculoResource;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }
}
