# Expense Tracker API

Projeto feito seguindo o roadmap de projetos do [roadmap.sh](https://roadmap.sh/projects/expense-tracker-api), com o objetivo de praticar desenvolvimento de APIs RESTful completas com Java e Spring Boot.

## Descrição

O **Expense Tracker API** é uma aplicação backend que permite gerenciar despesas pessoais via API REST.  
A API oferece:

- Registro e login de usuários
- Autenticação com JWT (token)
- Criação, leitura, atualização e remoção de despesas (CRUD)
- Filtros por intervalo de datas

A cada requisição, o usuário autenticado acessa apenas suas próprias despesas.

## Tecnologias utilizadas

- **Java** – Linguagem principal
- **Spring Boot** – Framework para construção da API
- **Maven** – Gerenciador de dependências
- **Spring Security** – Segurança e controle de acesso
- **JPA / Hibernate** – Mapeamento objeto-relacional
- **Flyway** – Versionamento e migração do banco de dados
- **JWT (JSON Web Tokens)** – Geração de token
- **PostgreSQL** – Banco de dados

## Como rodar o projeto

### 1. Baixe ou clone o repositório

```bash
git clone https://github.com/JessicaLorenzon/expense-tracker-api.git
```

### 2. Configure o banco de dados

Antes de executar a aplicação, configure o banco de dados com as informaçoes que estão no arquivo ```application.properties```

O Flyway será responsável por executar automaticamente as migrações do banco de dados ao iniciar a aplicação.

### 3. Execute a aplicação

```bash
java -jar target/expense-tracker-api-0.0.1.jar
```

### 4. Acesse a aplicação

A API estará disponível em: http://localhost:8080

## Endpoints disponíveis

### Autenticação

### 1. Registro de usuário

```http
POST /register
```

#### Payload (JSON):

```json
{
  "login": "John Doe",
  "password": "password"
}
```

### 2. Login

```http
POST /login
```

#### Payload (JSON):

```json
{
  "login": "John Doe",
  "password": "password"
}
```

### Despesas (necessita token no header Authorization)

### 1. Buscar todas as despesas

```http
GET /expenses
```

### 2. Buscar despesas por período

```http
GET /expenses?period=past-week
GET /expenses?period=past-month
GET /expenses?period=last-3-months
GET /expenses?startDate={yyyy-MM-dd}&endDate={yyyy-MM-dd}
```

### 3. Criar nova despesa

```http
POST /expenses
```

#### Payload (JSON):

```json
{
  "description": "Lunch",
  "amount": 40,
  "category": "groceries",
  "expenseDate": "2026-01-26"
}
```

### 4. Atualizar despesa

```http
PUT /expenses/{id}
```

#### Payload (JSON):

```json
{
  "description": "Lunch",
  "amount": 100,
  "category": "groceries",
  "expenseDate": "2026-01-27"
}
```

### 5. Deletar despesa

```http
DELETE /expenses/{id}
```