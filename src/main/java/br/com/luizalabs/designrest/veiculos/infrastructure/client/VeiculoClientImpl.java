package br.com.luizalabs.designrest.veiculos.infrastructure.client;

import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegado;
import br.com.luizalabs.designrest.veiculos.infrastructure.VeiculoLegadoRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Primary
@Service("veiculoClientImpl")
public class VeiculoClientImpl implements VeiculoClient {

    @Value("${services.veiculo.legado.url}")
    private String url;

    @Override
    public VeiculoLegado postVeiculo(VeiculoLegadoRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<VeiculoLegadoRequest> requestEnetity = new HttpEntity<>(request);
        ResponseEntity<VeiculoLegado> resp = restTemplate.postForEntity(url, requestEnetity, VeiculoLegado.class);
        return resp.getBody();
    }

    @Override
    public List<VeiculoLegado> postVeiculoListAll(VeiculoLegadoRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<VeiculoLegadoRequest> requestEnetity = new HttpEntity<>(request);
        ResponseEntity<List<VeiculoLegado>> resp =
                restTemplate.exchange(url, HttpMethod.POST, requestEnetity, new ParameterizedTypeReference<List<VeiculoLegado>>() {
                });
        return resp.getBody();
    }
}
