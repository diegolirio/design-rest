package br.com.luizalabs.designrest.veiculos.template;

import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoInputResource;
import br.com.luizalabs.designrest.veiculos.presentation.resources.VeiculoOutputResource;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

import java.time.LocalDateTime;

public class VeiculoFixtureTemplate implements TemplateLoader {

    public final static String LABEL_VEICULO_OUT_SEM_ID = "label-veiculo--out--sem-id";
    public final static String LABEL_VEICULO_IN_SEM_ID = "label-veiculo--in--sem-id";

    private static final String DATA_LANCE = "dataLance";
    private static final String LOTE = "lote";
    private static final String CODIGO_CONTROLE = "codigoControle";
    private static final String MARCA = "marca";
    private static final String MODELO = "modelo";
    private static final String ANO_FABRICACAO = "anoFabricacao";
    private static final String ANO_MODELO = "anoModelo";
    private static final String VALOR_LANCE = "valorLance";
    private static final String USUARIO_LANCE = "usuarioLance";

    @Override
    public void load() {
        Fixture.of(VeiculoOutputResource.class).addTemplate(LABEL_VEICULO_OUT_SEM_ID, new Rule() {
            {
                add(VeiculoFixtureTemplate.DATA_LANCE, LocalDateTime.now());
                add(VeiculoFixtureTemplate.LOTE, "0963");
                add(VeiculoFixtureTemplate.CODIGO_CONTROLE, "3150785");
                add(VeiculoFixtureTemplate.MARCA, "Fiat");
                add(VeiculoFixtureTemplate.MODELO, "Argo");
                add(VeiculoFixtureTemplate.ANO_FABRICACAO, 2018);
                add(VeiculoFixtureTemplate.ANO_MODELO, 2019);
                add(VeiculoFixtureTemplate.VALOR_LANCE, 35250.99D);
                add(VeiculoFixtureTemplate.USUARIO_LANCE, "diegolirio");
            }
        });
        Fixture.of(VeiculoInputResource.class).addTemplate(LABEL_VEICULO_IN_SEM_ID, new Rule() {
            {
                add(VeiculoFixtureTemplate.DATA_LANCE, LocalDateTime.now());
                add(VeiculoFixtureTemplate.LOTE, "0963");
                add(VeiculoFixtureTemplate.CODIGO_CONTROLE, "3150785");
                add(VeiculoFixtureTemplate.MARCA, "Tesla");
                add(VeiculoFixtureTemplate.MODELO, "Model X");
                add(VeiculoFixtureTemplate.ANO_FABRICACAO, 2017);
                add(VeiculoFixtureTemplate.ANO_MODELO, 2017);
                add(VeiculoFixtureTemplate.VALOR_LANCE, 150250.99D);
                add(VeiculoFixtureTemplate.USUARIO_LANCE, "diegolirio");
            }
        });
    }
}