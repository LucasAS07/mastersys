# 🏋️ MasterSys - Sistema de Gestão de Academia

## 📌 Sobre o Projeto

O **MasterSys** é uma API desenvolvida em **Java com Spring Boot** para
gerenciamento de academias.\
O sistema permite controlar alunos, matrículas, planos, frequência
(assiduidade) e faturamento.

Além disso, disponibiliza relatórios para análise financeira e
operacional da academia.

MasterSys é uma aplicação desktop desenvolvida em 2018 aqui fizemos uma versão backend x frontend dela.

------------------------------------------------------------------------

## 🚀 Tecnologias Utilizadas

-   Java 17+
-   Spring Boot
-   Spring Data JPA
-   Maven
-   PostgreSQL
-   Flyway
-   OpenAPI / Swagger

------------------------------------------------------------------------

## 📂 Estrutura do Projeto

    src/main/java/br/com/losystem/mastersys
    ├── config
    ├── controller
    ├── doc
    ├── dto
    ├── exception
    ├── model
    ├── projection
    ├── repository
    ├── service
    ├── specification

------------------------------------------------------------------------

## ⚙️ Funcionalidades

### 👤 Alunos

-   Cadastro de alunos
-   Atualização de dados
-   Listagem com filtros dinâmicos
-   Consulta detalhada

### 📋 Matrículas

-   Vinculação de alunos a planos
-   Controle de status

### 💰 Financeiro

-   Geração de faturas
-   Controle de pagamentos

### 📊 Relatórios

-   Faturamento mensal
-   Faturas em aberto
-   Alunos por cidade

### 📅 Assiduidade

-   Registro de presença

------------------------------------------------------------------------

## ▶️ Como Executar

### Pré-requisitos

-   Java 17+
-   Maven
-   PostgreSQL

### Configuração

Editar:

    src/main/resources/application.properties

Exemplo:

    spring.datasource.url=jdbc:postgresql://localhost:5432/mastersys
    spring.datasource.username=seu_usuario
    spring.datasource.password=sua_senha

------------------------------------------------------------------------

### Rodando

    ./mvnw spring-boot:run

------------------------------------------------------------------------

## 📡 Documentação

    http://localhost:8080/swagger-ui.html


