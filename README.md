# AppAcademy-Challenge
### Desafio de código da AppAcademy - Premier Soft

#### Getting started

Na pasta principal desse repositório há uma planilha chamada candidatos.csv contendo algumas informações básicas de alguns candidatos que se inscreveram para o AppAcademy, como nome, vaga, idade e estado. 
Para proteger a identidade dos participantes, os nomes foram gerados aleatoriamente. 
O seu programa deve consumir esses dados para atender os critérios descritos a seguir.

#### Sobre o desafio

O programa de capacitação da PremierSoft, o AppAcademy, contou com diversas inscrições.
Entender de onde vêm essas pessoas, qual vaga despertou mais interesse nelas e a faixa etária, são alguns dos números que podemos extrair desse programa.

Os números servem como indicadores para que possamos aperfeiçoar o AppAcademy nas suas futuras edições. 
Investir mais em regiões que tiveram uma taxa de adesão menor, seria uma das possíveis melhorias a se fazer. 

Portanto, para simplificar a contabilização desses indicadores e possibilitar a realização dessa mesma tarefa nas futuras edições, foi idealizado um programa que gera um relatório contendo os seguintes dados:


- a porcentagem de candidatos de Android, iOS e QA 
- a idade média dos candidatos de QA 
- o número de estados distintos presentes na lista 
- o nome do estado e a quantidade de candidatos dos 2 estados com menos ocorrências 
- ordena por ordem alfabética a lista de candidatos e salvar como Sorted_AppAcademy_Candidates.csv

#### O programa também deverá mostrar: 

Incluímos o nome dos instrutores de Android e iOS do AppAcademy na planilha. 
Queremos que o seu programa seja capaz de mostrar o nome do instrutor da vaga para qual você se inscreveu com base nas seguintes informações:

- o instrutor de iOS tem mais de 20 anos
- o instrutor de Android é mais esperto novo do que o instrutor do iOS
- a idade do instrutor de iOS é um número primo
- o primeiro nome do instrutor de Android tem 3 vogais
- a última letra do primeiro nome do instrutor de Android é a letra "o"
- a primeira letra do último nome do instrutor de iOS é a letra "V"
- a idade dos instrutores é um número ímpar
- os instrutores nasceram na mesma década
- os instrutores tem menos de 31 anos
- a vaga atribuída aos instrutores (na planilha) não é a vaga na qual eles vão instruir
- os instrutores são de SC


# Solução do Desafio

### Tecnologias utilizadas

- Java 11
- Spring Boot 2.5.0
- Docker
- Maven 3.6.3
- My SQL 8
- Postmann
- Github

### Como testar o programa

Para executar esta aplicação é preciso ter o Java versão 11 instalado na máquina.
É recomendado utilizar uma IDE como VS Code ou IntelliJ IDEA, o que permite compilar o programa para versões diferentes do Java. 
Podem ocorrer erros caso sejam utilizadas versões inferiores ou superiores do Java.
A escolha do banco de dados a ser utilizado pode ficar a critério do utilizador. 
Como o objetivo era apenas realizar o desenvolvimento da API, utilizei banco de dados MySQL.

É necessário ter o Docker instalado para rodar

o banco de dados. O mesmo pode ser baixado em:

https://www.docker.com/products/docker-desktop

Para rodar a imagem do MySQL em Docker é necessário executar o seguinte comando:

docker run --name MySQL -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sua-senha -d mysql:latest

Na sequência é necessário clonar esse repositório e importar o projeto na IDE.

É preciso configurar as seguintes variáveis de ambiente:

DB_URL=jdbc:mysql://localhost:3306/{informarNome}
DB_USER=root
DB_PASSWORD={sua-senha}

Utilizando sua IDE, executar AppAcademy localizado em:

classpath\src\main\java\com\premiersoft\appacademy\appacademy\AppAcademyApplication

Com todos os requisitos e a API em execução, pode-se utilizar o Postman para fazer as requisições aos endpoints da API.

#### Endpoints

| Ação                                           	| Endpoint          	| Método 	|
|------------------------------------------------	|-------------------	|--------	|
| Gravar Csv no banco                            	| /api/csv          	| Get    	|
| Retorna percentual por vaga                    	| /porc?vaga={vaga} 	| Get    	|
| Retorna idade média por vaga                   	| /idade/{vaga}     	| Get    	|
| Retorna quantidade de estados inscritos        	| /estados          	| Get    	|
| Retorna os estados com menos inscritos         	| /ultimos          	| Get    	|
| Gravar um arquivo CSV com candidatos ordenados 	| /gravarcsv        	| Get    	|
| Retorna o nome do instrutor de iOS             	| /ios              	| Get    	|
| Retorna o nome do instrutor de Android         	| /android          	| Get    	|
| Gera um relatório com todos os métodos         	| /relatorio        	| Get    	|

