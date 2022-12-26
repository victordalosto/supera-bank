# Processo Seletivo Java - Supera

## Desafio 05 

Este repositório contém uma API construida para o processo seletivo de BACKEND em JAVA, onde é construida uma camada de serviço para a emissão de extrato bancário.

O repositório contem duas funcionalidades implementadas em conjunto, a sua API REST, bem como a sua API para front end.

A <strong>API REST</strong> foi desenvolvida utilizando os frameworks do SPRING, como SPRING DATA JPA. <br>
O <strong>FRONT-END</strong> da aplicação foi desenvolvida utilizando o próprio Thymeleaf do SPRING, junto com a sua dependência WEB.

## Como executar:

Para execucar a aplicação, basta executar no prompt do diretório usando os seguintes comandos:

    ./mvnw clean package
    java -jar target/banco-1.0.jar


## Testar a API REST

Os end-points disponíveis para testar a API são testados no endereco:
`localhost`. Porta padrão :80.

`/api/extrato`: Disponibiliza um json contendo as movimentacoes financeiras do usuario. Devolve a 'Pagina extrato' com: Page<movimentacoes\> (Data, valor, tipo e operador), Saldo atual e somatório das movimentacoes no período filtrado.<br>
Aceita os seguintes parâmetros de movimentacoes para filtro: `id`, `operador`, `dataInicio` e `dataFim`. <br>
Como  parâmetros de filtros, aceita: `sort`, `size`, `page` e `direction`.<br/>
<strong>Exemplo: localhost/api/extrato?id=1&size=50&operador=beltrano</strong>

`/api/saldo`: Disponibiliza o saldo do usuario fornecido pelo parâmetro: `id`.

`/api/usuario`: Disponibiliza algumas informações do usuário fornecido pelo parâmetro: `id`, como: Nome, Agencia e Conta corrente. Esse end-point facilita a aplicação front-end na construção dos menus.


## Testar as páginas web

Para testar as páginas web, basta digitar no navegador o endereco: `localhost`.<br>
O usuário irá se deparar com a seguinte página de login da aplicação, construida em bootstrap, onde o usuário poderá se logar em qualquer um dos usuários que foram usados para popular o banco H2.
![tela-login](docs\images\login.png)

Em seguida, o usuário terá acesso a uma pagina construida com Thymeleaf, que faz apenas requisições à API REST, permitindo o acesso as principais funcionalidades da aplicação.<br>
A pagina é intuitiva e lhe uma representação visual de todas as requisições necessárias para se avaliar o extrato financeiro do usuário.
![tela-extrato](docs\images\extrato.PNG)
