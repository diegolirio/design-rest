# Read Me First

### Tecnologias

- Java 
- Spring

### API's

`Swagger:` http://localhost:8080/swagger-ui.html#/veiculo-controller   

---

1. Inclusão de veículos

```shell
curl --request POST \
  --url http://localhost:8080/v1/veiculos \
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
  --url http://localhost:8080/v1/veiculos/52 \
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
  --url http://localhost:8080/v1/veiculos/764
```
---
4. Busca Todos

```shell
curl --request GET \
  --url http://localhost:8080/v1/veiculos
```
---
5. Consulta de veículos por ID

```shell
curl --request GET \
  --url http://localhost:8080/v1/veiculos/764
```
---
6. Consulta dos veículos contidos em um lote
```shell
curl --request GET \
  --url http://localhost:8080/v1/veiculos/lote/0196
```
---
7. Consulta de veículos por marca
```shell
curl --request GET \
  --url http://localhost:8080/v1/veiculos/marca/CHEVROLET
```
---
8. Consulta de veículos pelas letras iniciais do modelo
```shell
curl --request GET \
  --url 'http://localhost:8080/v1/veiculos/ano?fabricacao=2007&modelo=2008'
```
---
9. Consulta de veículos pelo ano de fabricação e pelo ano do modelo (campos combinados) (*). Ex: veículos com ano de fabricação em 2015 e ano modelo 
```shell
curl --request GET \
  --url 'http://localhost:8080/v1/veiculos/ano?fabricacao=2007&modelo=2008'
```
---
10. Consulta de veículos por faixa de ano de fabricação (*). Ex: veículos fabricados entre 2013 e 2016.
```shell
curl --request GET \
  --url 'http://localhost:8080/v1/veiculos/ano-fabricacao?inicio=2009&fim=2009'
```
---
