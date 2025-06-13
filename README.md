# 🎬 Sistema de Locadora

Este é um sistema de gerenciamento de locadora desenvolvido como atividade avaliativa. Ele permite o cadastro de **clientes** e **filmes**, além da **realização e controle de locações**. O projeto foi construído com **Spring Boot**, **JPA**, **Lombok** e **MySQL**, com uma arquitetura organizada por domínio.

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL
- Maven

## 📁 Estrutura do Projeto



- **cliente**: gerenciamento de informações dos clientes.
- **filme**: cadastro e controle dos filmes disponíveis.
- **locacao**: registro de locações feitas pelos clientes.

## ⚙️ Configuração do Banco de Dados

Edite o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/locadora_db
spring.datasource.username=root
spring.datasource.password=suasenha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## Como executar:

1. Clone o repositório:
```
git clone https://github.com/seuusuario/locadora.git
cd locadora
```

2. Configure o banco de dados no application.properties;

3. Execute a aplicação:
```
./mvnw spring-boot:run
```
4. Acesse a Api:
  http://localhost:8080

## 🔄 Endpoints Principais

📌 Clientes
- GET /clientes
- GET /clientes/{id}
- POST /clientes
- PUT /clientes/{id}
- DELETE /clientes/{id}

🎞️ Filmes
- GET /filmes
- GET /filmes/{id}
- POST /filmes/{id}
- PUT /filmes/{id}
- DELETE /filmes/{id}

📦 Locação
- GET /locacoes
- GET /locacoes/{id}
- POST /locacoes | Exemplo de body: clienteId + filmeId + data_locacao + data_devolucao
- PUT /locacoes/{id}
- DELETE /locacoes/{id}

## 🐳 Como executar com Docker
Este projeto está containerizado usando Docker, permitindo subir tanto a aplicação quanto o banco de dados MySQL de forma prática.

## ✅ Pré-requisitos
Docker Desktop instalado

🚀 Passo a passo para rodar o projeto
1. Clone o repositório
```
git clone https://github.com/luanrrsouza/locadora.git
cd locadora
```
2. Suba os containers
```
docker-compose up --build
```
Este comando irá:

Gerar automaticamente o .jar da aplicação usando Maven dentro do Docker

Construir a imagem da aplicação com Spring Boot

Subir o container da aplicação em localhost:8080

Subir o container do MySQL em localhost:3306

3. Acesse a API
URL base: http://localhost:8080


 
