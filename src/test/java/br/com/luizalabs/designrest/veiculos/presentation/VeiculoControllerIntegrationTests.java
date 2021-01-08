package br.com.luizalabs.designrest.veiculos.presentation;

import br.com.luizalabs.designrest.DesignRestApplication;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoResource;
import br.com.luizalabs.designrest.veiculos.template.VeiculoFixtureTemplate;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = DesignRestApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.yml")
public class VeiculoControllerIntegrationTests {

    @Autowired
    private MockMvc mvc;

    @BeforeClass
    public static void init() {
        FixtureFactoryLoader.loadTemplates(VeiculoFixtureTemplate.class.getPackage().getName());
    }

    @Test
    public void consultarTodosPaginaZeroCom7VeiculosTest() throws Exception {
        String url = VeiculoController.VEICULOS_PREFIX_URL+"?page=0&size=7";
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(7)));
    }

    @Test
    public void consultarTodosPagina9Com12VeiculosTest() throws Exception {
        String url = VeiculoController.VEICULOS_PREFIX_URL+"?page=9&size=12";
        mvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(12)));
    }

    @Test
    public void consultarPorLoteTest() throws Exception {
        String lote = "0192";
        String path = "/lote/"+lote;
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$.links[0].href", notNullValue()))
                .andExpect(jsonPath("$[0].lote", is(lote)))
                .andExpect(jsonPath("$.links[0].href", notNullValue()))
                .andExpect(jsonPath("$[1].lote", is(lote)));
    }

    @Test
    public void consultarPorIniciaisModeloTest() throws Exception {
        String modelo = "C3 ";
        String path = String.format("/modelo?q=%s&page=0&size=4", modelo);
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(4)));
    }

    @Test
    public void consultarPorAnoFabriacaoModeloTest() throws Exception {
        Integer anoFabricacao = 2007;
        Integer anoModelo = 2008;
        String path = String.format("/fabricacao/%s/modelo/%s?size=3&page=0", anoFabricacao, anoModelo);
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].anoFabricacao", is(anoFabricacao)))
                .andExpect(jsonPath("$[0].anoModelo", is(anoModelo)))
                .andExpect(jsonPath("$[1].anoFabricacao", is(anoFabricacao)))
                .andExpect(jsonPath("$[1].anoModelo", is(anoModelo)))
                .andExpect(jsonPath("$[2].anoFabricacao", is(anoFabricacao)))
                .andExpect(jsonPath("$[2].anoModelo", is(anoModelo)));
    }

    @Test
    public void consultarPorAnoFabriacaoEntreTest() throws Exception {
        Integer anoFabricacaoInicio = 2008;
        Integer anoFabricacaoFim = 2013;
        String path = String.format("/anoFabricacao?inicio=%s&fim=%s&size=5&page=0", anoFabricacaoInicio, anoFabricacaoFim);
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(5)))
                .andExpect(jsonPath("$[0].anoFabricacao", greaterThanOrEqualTo(anoFabricacaoInicio)))
                .andExpect(jsonPath("$[0].anoFabricacao", lessThanOrEqualTo(anoFabricacaoFim)))
                .andExpect(jsonPath("$[2].anoFabricacao", greaterThanOrEqualTo(anoFabricacaoInicio)))
                .andExpect(jsonPath("$[2].anoFabricacao", lessThanOrEqualTo(anoFabricacaoFim)))
                .andExpect(jsonPath("$[4].anoFabricacao", greaterThanOrEqualTo(anoFabricacaoInicio)))
                .andExpect(jsonPath("$[4].anoFabricacao", lessThanOrEqualTo(anoFabricacaoFim)));
    }

    @Test
    public void consultarPorMarcaTest() throws Exception {
        String marca = "CHEVROLET";
        String path = String.format("/marca/%s", marca);
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].marca", is(marca)))
                .andExpect(jsonPath("$[3].marca", is(marca)));
    }

    @Test
    public void consultarPorIdTest() throws Exception {
        Integer id = 19;
        String path = String.format("/%s", id);
        mvc.perform(get(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", equalTo(id)));
    }

    @Test
    public void criarTest() throws Exception {
        String json = new ObjectMapper().writeValueAsString(
                Fixture.from(VeiculoResource.class).gimme(VeiculoFixtureTemplate.LABEL_VEICULO_SEM_ID));

        mvc.perform(post(VeiculoController.VEICULOS_PREFIX_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", CoreMatchers.notNullValue()));
    }

    @Test
    public void atualizarTest() throws Exception {
        Integer id = 52;
        String path = String.format("/%s", id);

        String json = new ObjectMapper().writeValueAsString(
                Fixture.from(VeiculoResource.class).gimme(VeiculoFixtureTemplate.LABEL_VEICULO_SEM_ID));

        mvc.perform(put(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.links[0].href", notNullValue()));
    }

    @Test
    public void excluirTest() throws Exception {
        Long id = 19L;
        String path = String.format("/%s", id);
        mvc.perform(delete(VeiculoController.VEICULOS_PREFIX_URL+path)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

}
