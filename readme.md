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
  --url http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/v1/veiculos?size=10&page=0
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
  --url 'http://localhost:8080/v1/veiculos/modelo?q=C3&size=3&page=0'
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

### Design do Código

> O Design do código foi construindo com base na arquitetura hexagonal e seguindo algumas técnicas do 
> DDD como Bundle-Context, linguagem única seguindo o enunciado do teste e os principios SOLID.
   
> O intuito do design de código é poder isolar as funcionalidades para que alterações futuras 
> não afetam umas as outras e obter agilidade em novas features. Então sendo assim o começo do 
> desenvolvimento é mais demorado mas com tempo em aplicações com domínio rico que possuem uma 
> evolução constante o tempo é convertido a nosso favor. 

![image](https://user-images.githubusercontent.com/3913593/103909277-44152700-50e2-11eb-986f-0110faa315fc.png)
 
> Para aplicações CRUD ou que ainda não está claro as regras e o conhecimento avançado 
> desse dominio, devemos seguir com um design mais simples para desenvolver uma aplicacao,
> como controller -> service -> repository. Acredito que isso deve estar sempre aberto para discussões. 

### Pipeline

`Github-actions:` https://github.com/diegolirio/design-rest/actions   
`Steps:` [./github/workflows/pipeline.yml](./github/workflows/pipeline.yml)   
`Image:` https://hub.docker.com/r/diegolirio/design-rest      
`HealthCheck:` http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/actuator/health   
`API:` http://ec2-3-218-141-213.compute-1.amazonaws.com:8085/swagger-ui.html   