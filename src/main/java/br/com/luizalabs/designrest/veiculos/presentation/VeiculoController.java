package br.com.luizalabs.designrest.veiculos.presentation;

import br.com.luizalabs.designrest.veiculos.application.alterar.VeiculoAlterar;
import br.com.luizalabs.designrest.veiculos.application.alterar.out.AlterarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.todos.VeiculoConsultar;
import br.com.luizalabs.designrest.veiculos.application.consultar.porano.VeiculoConsultarPorAnoFabricacaoAnoModelo;
import br.com.luizalabs.designrest.veiculos.application.consultar.porano.in.ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.VeiculoConsultarPorAnoFabricacao;
import br.com.luizalabs.designrest.veiculos.application.consultar.poranofabricacao.in.ConsultarVeiculoPorAnoFabricacaoInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.VeiculoConsultarPorId;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.in.ConsultarVeiculoPorIdInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porid.out.ConsultarVeiculoPorIdOutputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.VeiculoConsultarPorLote;
import br.com.luizalabs.designrest.veiculos.application.consultar.porlote.in.ConsultarVeiculoPorLoteInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.VeiculoConsultarPorMarca;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormarca.in.ConsultarVeiculoPorMarcaInputPort;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.VeiculoConsultarPorModelo;
import br.com.luizalabs.designrest.veiculos.application.consultar.pormodelo.in.ConsultarVeiculoPorModeloInputPort;
import br.com.luizalabs.designrest.veiculos.application.criar.VeiculoCriar;
import br.com.luizalabs.designrest.veiculos.application.criar.out.CriarVeiculoOutputPort;
import br.com.luizalabs.designrest.veiculos.application.excluir.VeiculoExcluir;
import br.com.luizalabs.designrest.veiculos.application.excluir.in.ExcluirVeiculoInputPort;
import br.com.luizalabs.designrest.veiculos.presentation.in.*;
import br.com.luizalabs.designrest.veiculos.presentation.out.ConsultarVeiculoOutputAdapter;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoInputResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoOutputResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResourceID;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

import static br.com.luizalabs.designrest.veiculos.presentation.VeiculoController.VEICULOS_PREFIX_URL;
import static br.com.luizalabs.designrest.veiculos.presentation.mapper.VeiculoMapper.INSTANCE;

@AllArgsConstructor
@RestController
@RequestMapping(VEICULOS_PREFIX_URL)
public class VeiculoController {

    public static final String VEICULOS_PREFIX_URL = "/v1/veiculos";

    private final VeiculoCriar veiculoCriar;
    private final VeiculoAlterar veiculoAlterar;
    private final VeiculoExcluir veiculoExcluir;
    private final VeiculoConsultar veiculoConsultar;
    private final VeiculoConsultarPorId veiculoConsultarPorId;
    private final VeiculoConsultarPorLote veiculoConsultarPorLote;
    private final VeiculoConsultarPorMarca veiculoConsultarPorMarca;
    private final VeiculoConsultarPorModelo veiculoConsultarPorModelo;
    private final VeiculoConsultarPorAnoFabricacaoAnoModelo veiculoConsultarPorAnoFabricacaoAnoModelo;
    private final VeiculoConsultarPorAnoFabricacao veiculoConsultarPorAnoFabricacao;

    @GetMapping
    @ApiOperation(value = "Consulta todos os veiculos")
    public List<VeiculoOutputResource> consultarTodos(@RequestParam(value = "page", defaultValue = "${pagination.page}") Integer page,
                                                      @RequestParam(value = "size", defaultValue = "${pagination.size}") Integer size) {
        List<ConsultarVeiculoOutputAdapter> listOutput = veiculoConsultar.execute(page, size);
        return INSTANCE.mapOut(listOutput);
    }

    @GetMapping("/lote/{lote}")
    public List<VeiculoOutputResource> consultarPorLote(@PathVariable("lote") String lote) {
        ConsultarVeiculoPorLoteInputPort inputPort = new ConsultarVeiculoPorLoteInputAdapter(lote);
        List<ConsultarVeiculoOutputAdapter> output = veiculoConsultarPorLote.execute(inputPort);
        return INSTANCE.mapOut(output);
    }

    @GetMapping("/modelo")
    public List<VeiculoOutputResource> consultarPorIniciaisModelo(@RequestParam("q") String q,
                                                                  @RequestParam(value = "page", defaultValue = "${pagination.page}") Integer page,
                                                                  @RequestParam(value = "size", defaultValue = "${pagination.size}") Integer size) {
        ConsultarVeiculoPorModeloInputPort inputPort = new ConsultarVeiculoPorModeloInputAdapter(q, page, size);
        List<ConsultarVeiculoOutputAdapter> output = veiculoConsultarPorModelo.execute(inputPort);
        return INSTANCE.mapOut(output);
    }

    @GetMapping("/fabricacao/{fabricacao}/modelo/{modelo}")
    public List<VeiculoOutputResource> consultarPorAnoFabriacaoModelo(@PathVariable("fabricacao") Integer fabricacao,
                                                                      @PathVariable("modelo") Integer modelo,
                                                                      @RequestParam(value = "page", defaultValue = "${pagination.page}") Integer page,
                                                                      @RequestParam(value = "size", defaultValue = "${pagination.size}") Integer size) {
        ConsultarVeiculoPorAnoFabricacaoAnoModeloInputPort inputPort =
                new ConsultarVeiculoPorAnoFabricacaoAnoModeloInputAdapter(fabricacao, modelo, page, size);
        List<ConsultarVeiculoOutputAdapter> output = veiculoConsultarPorAnoFabricacaoAnoModelo.execute(inputPort);
        return INSTANCE.mapOut(output);
    }

    @GetMapping("/anoFabricacao")
    public List<VeiculoOutputResource> consultarPorAnoFabriacaoEntre(@RequestParam("inicio") Integer inicio,
                                                                     @RequestParam("fim") Integer fim,
                                                                     @RequestParam(value = "page", defaultValue = "${pagination.page}") Integer page,
                                                                     @RequestParam(value = "size", defaultValue = "${pagination.size}") Integer size) {
        ConsultarVeiculoPorAnoFabricacaoInputPort inputPort =
                new ConsultarVeiculoPorAnoFabricacaoInputAdapter(inicio, fim, page, size);
        List<ConsultarVeiculoOutputAdapter> output = veiculoConsultarPorAnoFabricacao.execute(inputPort);
        return INSTANCE.mapOut(output);
    }

    @GetMapping("/marca/{marca}")
    public List<VeiculoOutputResource> consultarPorMarca(@PathVariable("marca") String marca) {
        ConsultarVeiculoPorMarcaInputPort inputPort = new ConsultarVeiculoPorMarcaInputAdapter(marca);
        List<ConsultarVeiculoOutputAdapter> output = veiculoConsultarPorMarca.execute(inputPort);
        return INSTANCE.mapOut(output);
    }

    @GetMapping("/{id}")
    public VeiculoOutputResource consultarPorId(@PathVariable Long id) {
        ConsultarVeiculoPorIdInputPort inputPort = new ConsultarVeiculoPorIdInputAdapter(id);
        ConsultarVeiculoPorIdOutputPort outputPort = veiculoConsultarPorId.execute(inputPort);
        return INSTANCE.mapOut(outputPort);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public VeiculoResourceID criar(@Valid @RequestBody VeiculoInputResource veiculoResource) {
        CriarVeiculoInputAdapter inputAdapter = INSTANCE.mapInputCriar(veiculoResource);
        CriarVeiculoOutputPort outputPort = veiculoCriar.execute(inputAdapter);
        return INSTANCE.mapOut(outputPort);
    }

    @PutMapping("/{id}")
    public VeiculoOutputResource atualizar(@NotEmpty(message = "Id Obrigatorio") @PathVariable String id,
                                           @RequestBody VeiculoInputResource veiculoResource) {
        AlterarVeiculoInputAdapter inputAdapter = INSTANCE.mapInputAlterar(veiculoResource);
        AlterarVeiculoOutputPort outputPort = veiculoAlterar.execute(inputAdapter, id);
        return INSTANCE.mapOutAlterar(outputPort);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void excluir(@NotNull(message = "Id Obrigatorio") @PathVariable Long id) {
        ExcluirVeiculoInputPort inputPort = new ExcluirVeiculoInputAdapter(id);
        ExcluirVeiculoInputAdapter inputAdapter = INSTANCE.mapInputExcluir(inputPort);
        veiculoExcluir.execute(inputAdapter);
    }

}
