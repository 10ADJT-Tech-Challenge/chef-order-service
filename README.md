# Chef Manager API - Sistema de Gestão Gastronômica Compartilhada

## 📋 Sobre o Projeto

Chef Manager API é um sistema de gestão gastronômica desenvolvido como parte do Tech Challenge da Fase 2. O projeto implementa uma API RESTful para gerenciamento de restaurantes, permitindo o cadastro de estabelecimentos, gestão de cardápios e diferentes tipos de usuários.

---

## 🏗️ Arquitetura

O projeto utiliza Clean Architecture para garantir uma estrutura modular e de fácil manutenção:

```
src/
    ├── core/                         # Entidades e regras de negócio 
    └── infrastructure/               # Implementações de repositórios e serviços externos
```

### Principais Tecnologias

- Java 25
- Spring Boot 4.0.0
- Spring Data JPA
- PostgreSQL
- Docker & Docker Compose
- OpenAPI/Swagger
- Lombok
- MapStruct

---

## 🚀 Como Executar

### Pré-requisitos

- Docker e Docker Compose
- Java 25 (para desenvolvimento)
- Git

### Passos para Execução

#### 1. Clone o repositório:
```bash
git clone git@github.com:10ADJT-Tech-Challenge/chef-order-api.git
cd chef-order-api
```
#### 2. Configure as variáveis de ambiente:
```bash
cp .env.example .env
``` 
Edite o arquivo .env com suas configurações
#### 3. Inicie os serviços com Docker Compose:
```bash
docker-compose up --build
```

---

## 📚 Documentação da API

A documentação completa da API está disponível através do Swagger UI:
`http://localhost:8081/api/v1/swagger-ui.html`

### 👥 Usuários
- **POST** `/api/v1/usuarios` - Cadastro de usuário
- **GET** `/api/v1/usuarios?nome={nome}` - Busca usuário por nome
- **GET** `/api/v1/usuarios/{id}` - Busca usuário por ID
- **PUT** `/api/v1/usuarios/{id}` - Atualiza dados do usuário
- **DELETE** `/api/v1/usuarios/{id}` - Remove usuário
- **PATCH** `/api/v1/usuarios/{id}/senha` - Altera senha

### 🏷️ Tipos de Usuário
- **POST** `/api/v1/tipos-usuario` - Cadastra novo tipo
- **GET** `/api/v1/tipos-usuario` - Lista todos os tipos
- **GET** `/api/v1/tipos-usuario/{id}` - Busca tipo por ID
- **PUT** `/api/v1/tipos-usuario/{id}` - Atualiza tipo
- **DELETE** `/api/v1/tipos-usuario/{id}` - Remove tipo

### 🍽️ Restaurantes
- **POST** `/api/v1/restaurantes` - Cadastra restaurante
- **GET** `/api/v1/restaurantes` - Lista restaurantes
- **GET** `/api/v1/restaurantes/{id}` - Busca restaurante por ID
- **PUT** `/api/v1/restaurantes/{id}` - Atualiza restaurante
- **DELETE** `/api/v1/restaurantes/{id}` - Remove restaurante

### 📋 Cardápio
- **POST** `/api/v1/restaurante/{restauranteId}/itens-cardapio` - Adiciona item ao cardápio
- **GET** `/api/v1/restaurante/{restauranteId}/itens-cardapio` - Lista itens do cardápio por id restaurante
- **GET** `/api/v1/restaurante/{restauranteId}/itens-cardapio?term='nomeItem'` - Lista itens do cardápio por id restaurante e nome de item
- **GET** `/api/v1/itens-cardapio?nome='nomeItem'` - Busca item por nome
- **GET** `/api/v1/itens-cardapio/{id}` - Busca item por ID
- **PUT** `/api/v1/itens-cardapio/{id}` - Atualiza item
- **DELETE** `/api/v1/itens-cardapio/{id}` - Remove item

**Base URL**: `http://localhost:8081/api/v1`

**Nota**: Todos os IDs são no formato UUID.

---

## 🧪 Testes

O projeto inclui testes unitários e de integração. 
Para executar os testes:
```bash 
./gradlew test 
```

Para gerar relatório de cobertura de testes:

```bash 
./gradlew test jacocoTestReport sonar `
  "-Dsonar.projectKey=chef-order-api" `
  "-Dsonar.projectName=chef-order-api" `
  "-Dsonar.host.url=http://localhost:9000" `
  "-Dsonar.token=sqp_49a83fe752449b518c0413f2a5d482373f198baa"

```
O relatório será gerado em: `build/reports/jacoco/test/html/index.html`
E estara disponível no SonarQube na URL configurada.

---

## 📝 Postman Collection

A collection do Postman com todos os endpoints está disponível em:
[.postman/ChefManagerApi.postman_collection.json](https://github.com/10ADJT-Tech-Challenge/chef-manager-api/blob/main/.postman/ChefManagerApi.postman_collection.json)



---

## 🎥 Vídeo de Apresentação

[Vídeo de apresentação](https://youtu.be/9z_a6-WOrBM)


---

## 🧱 Licença
Este projeto é de uso educacional, desenvolvido como parte de um estudo de **Tech Challenge 02 do curso de Pós-Graduação de Arquitetura de software com Java, na FIAP**.

