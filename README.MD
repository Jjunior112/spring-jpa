# 📦 Library System

Sistema de gerenciamento de biblioteca que permite o cadastro, leitura e exclusão de livros, editoras, autores e resenhas, implementado em Java utilizando Hibernate e PostgreSQL como banco de dados relacional.

---

## 🚀 Tecnologias Utilizadas

- [Java](https://www.oracle.com/java/)
- [Hibernate](https://hibernate.org/)
- [Docker](https://www.docker.com/)
- [PostgreSQL](https://www.postgresql.org/)

---

## 🧱 Estrutura do Projeto

```plaintext
spring-jpa
│
├── controllers/
│    ├── AuthorController                # controller de autores
│    ├── BookController                  # controller de livros
│    ├── PublisherController             # controller de editoras
│    ├── ReviewController                # controller de review
│
├── dtos/
│    ├── AuthorRecordDto                 # dto de autores
│    ├── BookRecordDto                   # dto de livros
│    ├── PublisherRecordDto              # dto de editoras
│    ├── ReviewRecordDto                 # dto de review
│
├── exceptions/
│    ├── DeletionException               # Exception para erros de exclusão
│    ├── ResourceNotFoundException       # Exception para erros de recursos não encotrados
│
├── models/
│    ├── Author                          # model de autor
│    ├── Book                            # model de livro
│    ├── Publisher                       # model de editora
│    ├── Review                          # model de review
│
├── repositories/
│    ├── AuthorRepository                # repository de autor
│    ├── BookRepository                  # repository de livro
│    ├── PublisherRepository             # repository de editor
│    ├── ReviewRepository                # repository de review
│
├── services/
│    ├── AuthorService                   # service de autores
│    ├── BookService                     # service de livros
│    ├── PublisherService                # service de editoras
│    ├── ReviewService                   # service de review
│
└──

```

---

## 🐳 Como Rodar o Projeto

### Pré-requisitos

- Docker
- Docker Compose

### Instruções

1. Clone o repositório:

```bash
git https://github.com/Jjunior112/spring-jpa
cd spring-jpa
```

2. Inicie o PostgreSQL via Docker::

```bash
docker-compose up --build
```

3. Inicie o sistema:

```bash
./mvnw spring-boot:run
```

---

## 🔁 Serviços Disponíveis

| Serviço          | Rota       | Descrição                                        |
| ---------------- | ---------- | -------------------------------------------------|
| BookService      | /book      | CRUD  de livros                                  |
| AuthorService    | /author    | CRUD  de autores                                 |
| PublisherService | /publisher | CRUD  de editoras (com validação de integridade) |
| ReviewService    | /review    | CRUD  de reviews                                 |

> Todos os endpoints devem ser acessados em (`localhost:8080`)
> As portas padrões podem ser alteradas no arquivo de configuração (`application.properties`).

---

## Rotas

### Autores

- **GET /author**

  - Retorna a lista de todos os autores.
  - **Exemplo de resposta:**
    ```json
    [
      {
        "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
        "name": "jose"
      }
    ]
    ```

- **GET /author/{id}**

  - Retorna um autor específico com base no ID.
  - **Exemplo de resposta:**
    ```json
    {
      "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
      "name": "jose"
    }
    ```

- **POST /author**
  - Cria um novo registro de autor.
  - **Exemplo de corpo de requisição:**
    ```json
    {
      "name": "jose"
    }
    ```
- **DELETE /author/{id}**
  - Exclui um autor.

### Livros

- **GET /book**

  - Retorna a lista de todos os livros.
  - **Exemplo de resposta:**
    ```json
    [
      {
        "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
        "title": "Aventuras de José",
        "publisherId": "cbd8455a-1d23-4e5d-8bb7-17d1a4567e12",
        "authorsIds": ["9a1b3c2d-4f5e-6789-abcd-1234567890ef"],
        "reviewComment": "Um livro excelente sobre coragem e superação."
      }
    ]
    ```

- **GET /book/{id}**

  - Retorna um livro específico com base no ID.
  - **Exemplo de resposta:**
    ```json
    {
      "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
      "title": "Aventuras de José",
      "publisherId": "cbd8455a-1d23-4e5d-8bb7-17d1a4567e12",
      "authorsIds": ["9a1b3c2d-4f5e-6789-abcd-1234567890ef"],
      "reviewComment": "Um livro excelente sobre coragem e superação."
    }
    ```

- **POST /book**
  - Cria um novo registro de livro.
  - **Exemplo de corpo de requisição:**
    ```json
    {
      "title": "Aventuras de José",
      "publisherId": "cbd8455a-1d23-4e5d-8bb7-17d1a4567e12",
      "authorsIds": ["9a1b3c2d-4f5e-6789-abcd-1234567890ef"],
      "reviewComment": "Um livro excelente sobre coragem e superação."
    }
    ```
- **DELETE /book/{id}**
  - Exclui um livro com base no ID.

### Editora

- **GET /publisher**

  - Retorna a lista de todos as editoras.
  - **Exemplo de resposta:**
    ```json
    [
      {
        "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
        "name": "Editora Central"
      }
    ]
    ```

- **GET /publisher/{id}**

  - Retorna uma editora específica com base no ID.
  - **Exemplo de resposta:**
    ```json
    {
      "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
      "name": "Editora Central"
    }
    ```

- **POST /publisher**
  - Cria um novo registro de editora.
  - **Exemplo de corpo de requisição:**
    ```json
    {
      "name": "Editora Central"
    }
    ```
- **DELETE /publisher/{id}**
  - Exclui uma editora com base no ID. Caso exista algum livro associado à editora, uma exceção é lançada impedindo a exclusão.

### Review

- **GET /review**

  - Retorna a lista de todos os reviews.
  - **Exemplo de resposta:**
    ```json
    [
      {
        "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
        "comment": "Uma leitura envolvente e bem escrita."
      }
    ]
    ```

- **GET /review/{id}**

  - Retorna um review específico com base no ID.
  - **Exemplo de resposta:**
    ```json
    {
      "id": "acc51146-8873-4cff-ac5f-ab854a75c13b",
      "comment": "Uma leitura envolvente e bem escrita."
    }
    ```

## 📄 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).
