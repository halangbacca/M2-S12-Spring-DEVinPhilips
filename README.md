# API REST - LABMedical
- API REST de uma aplicação Front-End para gestão de inventário médico

## Tecnologias utilizadas
- Java 17
- Spring Framework 3.0.5
- MySQL 18

## Dependências do Spring
- Lombok
- Flyway

## Diagrama
<img src="https://github.com/halangbacca/M2-S12-Spring-DEVinPhilips/blob/develop/img/digrama.png"/>

## Códigos Oracle
- Caso você deseje utilizar o banco de dados Oracle, é possível substituir as migrations do Flyway pelos scripts PL/SQL que estão na raiz do projeto, dentro do diretório oracle

## Collection Postman
- Os arquivos utilizados nas requisições HTTP estão na raiz do projeto, dentro do diretório postman

## Como executar
- Clonar o repositório para a sua máquina
- Baixar e instalar o sistema de gerenciamento de banco de dados (SGBD) MySQL
- Definir um usuário e senha no MySQL
- Criar a database através do comando "CREATE DATABASE labmedicalbd" ou através de um cliente SQL (o Flyway manipula apenas a criação do esquema, não a criação do banco de dados)
- Baixar e instalar o Java Development Kit (JDK) >= 17
- Baixar e instalar um cliente SQL, como o DBeaver, MySQL Workbench ou Oracle SQL Developer
- Baixar e instalar o IntelliJ IDEA ou outra IDE de sua preferência
- Baixar e instalar o Postman ou Insomnia REST
- Baixar a collection do Postman ou Insomnia REST
- Configurar o arquivo application.properties, definindo o usuário e senha do seu banco de dados MySQL
- Executar a API REST através da IDE
- O Flyway irá carregar os dados inicias
- Executar as requisições no Postman ou Insomnia REST

## Funcionalidades
- Carregamento de dados iniciais (Flyway)
  - Pacientes
  - Usuários (médicos)
  - Endereços
  - Consultas
  - Exames
  
- Cadastros
  - Cadastro de paciente
  - Cadastro de usuário (médico)
  - Cadastro de endereço
  - Cadastro de consulta
  - Cadastro de exame

- Listagens
  - Listagem de pacientes por nome (query opcional)
  - Listagem de todos os pacientes
  - Listagem de todos os endereços
  - Listagem de paciente por ID
  - Listagem de consulta por ID
  - Listagem de exame por ID

- Estatísticas
  - Estatísticas de pacientes
  - Estatísticas de exames
  - Estatísticas de consultas

- Deleções
  - Deleção de pacientes por ID
  - Deleção de consultas por ID
  - Deleção de exames por ID

- Atualizações
  - Atualização de usuário (médico) por ID
  - Atualização da senha de usuário (médico) por ID
  - Atualização de paciente por ID
  - Atualização de consulta por ID
  - Atualização de exame por ID
  
- Validações
  - Data e hora validadas pelo timestamp
  - Impede o cadastro de paciente e usuário com o mesmo número de CPF
  - Impede a modificação de CPF e RG ao atualizar os dados de pacientes e usuários
  - Tamanho mínimo de 8 caracteres alfanuméricos para a senha do usuário
  - Não permite excluir paciente que possua exames e/ou consultas
  - Validação de especialidade e estado civil usando enums
  - Impede a atualização da data e hora ao atualizar exames e consultas

- Exceptions
  - Tratador de erros:
    - Erro 400 (Bad Request)
    - Erro 404 (Not Found)
    - Erro 409 (Conflict)
    
- Data Transfer Object (DTOs)
  - Substituição de classes DTO pelos records, introduzidos de maneira experimental na versão 14 do Java e liberadas de forma oficial na versão 16

## Melhorias que podem ser implementadas
- Validação de número de telefone
- Validação de gênero
- Validação de CEP
- Validação de RG
- Validação de URL
- Utilização de builders
- Reaproveitamento de código
- Refatorar o tratamento de exceções
