<h1 align="center">🚀 Gerenciador de Estoque Itinerante (API) 🚀</h1>
<p align="center"> Tornando o processo de controle de mercadorias mais automatizado, organizado e seguro. </p>

### Índice :pushpin:

<!--ts-->
- <a href="#feature">Feature</a>
- <a href="#tech">Tecnologias e Dependências</a>
- <a href="#swagger">Execução no Swagger</a>
- <a href="#dependencia">Dependências</a>
<!--te-->

<div id="feature">
    <h3> Feature :computer: </h3>
</div>

- [x] Projeto inicialmente elaborado para uma ONG, afim de auxiliar na gestão 
da entrada e saída de produtos de qualquer lugar do país.

<div id="tech">
  <h3> Tecnologias e Dependências 🛠  </h3>
</div>

* Git
* Java 15
* Maven
* Springboot 2.5.2
* Lombok
* Mockito
* MongoDB
* Swagger 3.0.0
  
<div id="swagger">
  <h3> Execução no Swagger :arrow_forward:  </h3>
</div>

- Execute o projeto;
- Abra o Swagger UI: http://localhost:8080/swagger-ui/

#### :white_check_mark: Cadastro de um Produto
Input: POST:"/api/v1/inventory"
 ```bash
{
    "category": {
        "name": "Camiseta"
    },
    "color": "Branco",
    "description": "Descrição do Produto. Ex.: Camiseta de manga longa",
    "name": "None do Produto. Ex.: Camiseta Top",
    "storagePlaces": [
        {
            "address": {
                "city": "São Paulo",
                "country": "Brasil",
                "neighborhood": "Santana",
                "number": "10",
                "state": "SP",
                "street": "Rua da Alegria",
                "zipCode": "04245-350"
            },
            "quantity": 20
        }
    ],
    "unitaryValue": 50
}

```

#### :white_check_mark: Listagem de todos os Produtos
Input: GET:"/api/v1/inventory/all"

#### :white_check_mark: Busca por um Produto específico
Input: GET:"/api/v1/inventory/{id}"

#### :white_check_mark: Atualiza um Produto
Input: PUT:"/api/v1/inventory/{id}"
 ```bash
{
    "category": {
        "name": "Camiseta"
    },
    "color": "Branco",
    "description": "Descrição do Produto. Ex.: Camiseta de manga longa",
    "name": "None do Produto. Ex.: Camiseta Top",
    "storagePlaces": [
        {
            "address": {
                "city": "São Paulo",
                "country": "Brasil",
                "neighborhood": "Santana",
                "number": "10",
                "state": "SP",
                "street": "Rua da Alegria",
                "zipCode": "04245-350"
            },
            "quantity": 20
        }
    ],
    "unitaryValue": 50
}

```

#### :white_check_mark: Deleta um Produto
Input: DELETE:"/api/v1/inventory/{id}"

<div id="dependencia">
    <h3> Dependências ❗️❗️❗️ </h3>
</div>
https://github.com/pattrie/inventory-control-user
