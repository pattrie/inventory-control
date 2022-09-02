<h1 align="center">🚀 Gerenciador de Estoque Itinerante (API) 🚀</h1>
<p align="center"> Tornando o processo de controle de mercadorias mais automatizado, organizado e seguro. </p>

### Índice :pushpin:

<!--ts-->
- <a href="#feature">Feature</a>
- <a href="#tech">Tecnologias e Dependências</a>
- <a href="#swagger">Execução no Swagger</a>
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
* MySql
* Swagger 3.0.0
  
<div id="swagger">
  <h3> Execução no Swagger :arrow_forward:  </h3>
</div>

- Execute o projeto;
- Abra o Swagger UI: http://localhost:8080/swagger-ui/

#### :white_check_mark: Cadastro de Endereço
Input: GET:"/api/v1/inventory"
 ```bash
{
  "sku": "code123",
  "name": "boné padrão",
  "description": "boné super lindão",
  "color": "verde",
  "unitaryValue": 15.00,
  "category": {
    "name": "BONE"
  },
  "supplier": {
    "name": "fornecedor1",
    "cnpj": "8888867890"
  },
  "storagePlaces": [
    {
        "quantity": 15,
        "address": {
        "zipcode": "12345-678",
        "street": "Rua Rua",
        "number": "1",
        "city": "São Paulo",
        "neighborhood": "Bairro Bairro",
        "state": "SP",
        "country": "Brasil"
      }
    }
  ]
}

```
