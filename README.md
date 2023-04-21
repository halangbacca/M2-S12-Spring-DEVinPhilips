# API REST - LABMedical
- API REST de uma aplicação Front-End para gestão de inventário médico

## Tecnologias utilizadas
- Java 17
- Spring Framework 3.0.5
- MySQL 18

## Dependências do Spring
- Lombok
- Flyway

## Como executar
- Clonar o repositório para a sua máquina
- Baixar e instalar o MySQL
- Definir um usuário e senha no MySQL
- Baixar e instalar um sistema de gerenciamento de banco de dados (SGBDs) como o DBeaver ou Oracle SQL Developer
- Baixar e instalar o Java Development Kit (JDK) >= 17
- Baixar e instalar o IntelliJ IDEA ou outra IDE de sua preferência
- Baixar e instalar o Postman ou Insomnia REST
- Baixar a collection do Postman ou Insomnia REST
- Configurar o arquivo application.properties definindo o usuário e senha do seu banco de dados MySQL
- Executar o código através da IDE
- O Flyway criará um novo banco de dados e carregará os dados inicias
- Executar os comandos no Postman ou Insomnia REST

## Funcionalidades
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
  - Atualização da senha de usuário por ID
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
    - Erro 400 (SQLIntegrityConstraintViolationException e MethodArgumentNotValidException)
    - Erro 404 (EntityNotFoundException)
    
- Data Transfer Object (DTOs)
  - Substituição de classes DTO pelos records, introduzidos de maneira experimental na versão 14 do Java e liberadas de forma oficial na versão 16

## Melhorias a serem implementadas
- Validação de número de telefone
- Validação de gênero
- Validação de CEP
- Validação de RG
- Validação de URL
- Utilização de builders
- Reaproveitamento de código