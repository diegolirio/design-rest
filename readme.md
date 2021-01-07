# Read Me First

### Tecnologias

- Java 
- Spring

### API's

`Swagger:` http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/swagger-ui.html#/veiculo-controller

---

1. Inclusão de veículos

```shell
curl --request POST \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos \
  --header 'Content-Type: application/json' \
  --data '  {
    "dataLance": "21/08/2020 - 10:24",
    "lote": "123",
    "codigoControle": "222",
    "marca": "Tesla",
    "modelo": "Model X",
    "anoFabricacao": "2020",
    "anoModelo": "2021",
    "valorLance": 152000,
    "usuarioLance": "diegolirio"
  }'
```
---

2. Alteração de veículos

```shell
curl --request PUT \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos/52 \
  --header 'Content-Type: application/json' \
  --data '  {
    "dataLance": "11/12/2020 - 21:30",
    "lote": "123",
    "codigoControle": "222",
    "marca": "Tesla",
    "modelo": "Model X",
    "anoFabricacao": "2020",
    "anoModelo": "2021",
    "valorLance": 152000,
    "usuarioLance": "diegolirio"
  }'
```

---

3. Exclusão de veículos

```shell
curl --request DELETE \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos/764
```
---
4. Busca Todos

```shell
curl --request GET \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos?limit=10&offset=0
```
---
5. Consulta de veículos por ID

```shell
curl --request GET \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos/764
```
---
6. Consulta dos veículos contidos em um lote
```shell
curl --request GET \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos/lote/0196
```
---
7. Consulta de veículos por marca
```shell
curl --request GET \
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos/marca/CHEVROLET
```
---
8. Consulta de veículos pelas letras iniciais do modelo
```shell
curl --request GET \
  --url 'http://localhost:8080/v1/veiculos/modelo?q=C3&limit=3&offset=0'
```
---
9. Consulta de veículos pelo ano de fabricação e pelo ano do modelo (campos combinados) (*). Ex: veículos com ano de fabricação em 2015 e ano modelo 
```shell
curl --request GET \
  --url http://localhost:8080/v1/veiculos/fabricacao/2007/modelo/2008
```
---
10. Consulta de veículos por faixa de ano de fabricação (*). Ex: veículos fabricados entre 2013 e 2016.
```shell
curl --request GET \
  --url 'http://localhost:8080/v1/veiculos/anoFabricacao?inicio=2009&fim=2009'
```
---

### Design do Codigo

> O Design do codigo foi construindo pensando em arquitetura hexagonal e seguindo algumas tecnicas do DDD como 
> Bundle-Context, linguagem unica seguindo o enunciado do teste e os principios solid.
   
> O intuito do design de codigo eh poder isolar as funcionalidades para que alteracoes futuras 
> nao afetam umas as outras e ganhar agilidade em novas features. Entao sendo assim o comeco do 
> desenvolvimento eh mais demorado mas com tempo em aplicacoes com dominio rico que possuem uma 
> evolucao constante o tempo eh convertido a nosso favor. 

![image](https://user-images.githubusercontent.com/3913593/103909277-44152700-50e2-11eb-986f-0110faa315fc.png)
 
> Para aplicacoes CRUD ou que ainda nao esta claro as regras e o conhecimento avancado 
> desse dominio, constuiria uma aplicacao com um design mais simples 
> como controller -> service -> repository. Acredito que isso deve estar sempre aberto para discussoes. 

### Pipeline

`Github-actions:` https://github.com/diegolirio/design-rest/actions   
`Steps:` [./github/workflows/pipeline.yml](./github/workflows/pipeline.yml)   
`Image:` https://hub.docker.com/r/diegolirio/design-rest      
`HealthCheck:` http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/actuator/health   
`API:` http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/swagger-ui.html   