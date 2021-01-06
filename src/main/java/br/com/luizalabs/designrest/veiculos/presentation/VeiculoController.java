package br.com.luizalabs.designrest.veiculos.presentation;

import br.com.luizalabs.designrest.veiculos.application.alterar.VeiculoAlterar;
import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.VeiculoCriar;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.presentation.in.AlterarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.in.CriarVeiculoInputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

import static br.com.luizalabs.designrest.veiculos.presentation.VeiculoController.VEICULOS_PREFIX_URL;
import static br.com.luizalabs.designrest.veiculos.presentation.mapper.VeiculoMapper.mapper;

@AllArgsConstructor
@RestController
@RequestMapping(VEICULOS_PREFIX_URL)
public class VeiculoController {

    public static final String VEICULOS_PREFIX_URL = "/v1/veiculos";

    private final VeiculoCriar veiculoCriar;
    private final VeiculoAlterar veiculoAlterar;

    /*
            OK - 1. Inclusão de veículos
            2. Alteração de veículos
            3. Exclusão de veículos
            4. Consulta de todos os veículos
            5. Consulta de veículos por ID
            6. Consulta dos veículos contidos em um lote
            7. Consulta de veículos por marca
            8. Consulta de veículos pelas letras iniciais do modelo
            9. Consulta de veículos pelo ano de fabricação e pelo ano do modelo (campos combinados) (*). Ex: veículos com ano de fabricação em 2015 e ano modelo 2016.
            10. Consulta de veículos por faixa de ano de fabricação (*). Ex: veículos fabricados entre 2013 e 2016.

            // TODO 4 busca todos,
            //    6 busca por lote,
            //    7 busca por marca,
            //    8 busca por iniciais do modelo,
            //    9 busca veiculos por anoFabr/AnoModelo,
            //    10 busca between ano de fabr
     */

    @GetMapping
    public List<VeiculoResource> getAll() {
        return List.of(new VeiculoResource());
    }

    @GetMapping("/{id}")
    public VeiculoResource getById(@PathVariable Long id) {
        return new VeiculoResource();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public VeiculoResourceID create(@Valid @RequestBody VeiculoResource veiculoResource) {
        CriarVeiculoInputAdapter inputAdapter = mapper.mapInputCriar(veiculoResource);
        CriarVeiculoOutputPort outputPort = veiculoCriar.execute(inputAdapter);
        return mapper.mapOut(outputPort);
    }

    @PutMapping("/{id}")
    public VeiculoResource update(@NotEmpty(message = "Id Obrigatorio") @PathVariable String id,
                                  @RequestBody VeiculoResource veiculoResource) {
        AlterarVeiculoInputAdapter inputAdapter = mapper.mapInputAlterar(veiculoResource);
        AlterarVeiculoOutputPort outputPort = veiculoAlterar.execute(inputAdapter, id);
        return mapper.mapOutAlterar(outputPort);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {

    }
}
