# Projeto MongoDB com Spring Boot

Este projeto foi desenvolvido com base no curso **Programação Orientada a Objetos com Java** do **Prof. Dr. Nelio Alves**, com o objetivo de demonstrar o uso do **MongoDB** em conjunto com o **Spring Boot**, implementando operações de CRUD, associações entre objetos e consultas personalizadas.

---

## 🎯 Objetivos do Projeto

- Compreender as diferenças entre o paradigma **orientado a documentos** e o **relacional**
- Implementar operações de **CRUD**
- Refletir sobre **decisões de design** em bancos de dados orientados a documentos
- Implementar **associações entre objetos**
  - Objetos aninhados
  - Referências
- Realizar consultas com **Spring Data** e **MongoRepository**

---

## ⚙️ Tecnologias Utilizadas

- **Java 8+**
- **Spring Boot (1.5.x ou 2.x.x)**
- **Spring Data MongoDB**
- **MongoDB Community Server**
- **MongoDB Compass**
- **Maven**

---

## 🧩 Estrutura do Projeto

```
src/
 ├── main/
 │   ├── java/com/example/workshopmongo/
 │   │   ├── domain/          # Entidades do sistema (User, Post)
 │   │   ├── dto/             # Data Transfer Objects (UserDTO, AuthorDTO, CommentDTO)
 │   │   ├── repository/      # Interfaces MongoRepository (UserRepository, PostRepository)
 │   │   ├── services/        # Regras de negócio (UserService, PostService)
 │   │   ├── resources/       # Controladores REST (UserResource, PostResource)
 │   │   ├── config/          # Carga inicial de dados (Instantiation)
 │   │   └── resources/exception/ # Tratamento de exceções
 │   └── resources/
 │       └── application.properties
 └── test/
```

---

## 🧠 Conceitos Abordados

### 1. **Entidades e Documentos**
- Classe `User` anotada com `@Document`
- Identificador `@Id`
- Relacionamentos entre `User` e `Post` usando `@DBRef(lazy = true)`

### 2. **Data Transfer Object (DTO)**
- Redução de dados trafegados entre servidor e cliente
- Proteção de informações sensíveis
- Personalização dos dados retornados via REST

### 3. **Operações CRUD**
- `GET /users` – lista todos os usuários  
- `GET /users/{id}` – busca um usuário por ID  
- `POST /users` – insere um novo usuário  
- `PUT /users/{id}` – atualiza um usuário existente  
- `DELETE /users/{id}` – exclui um usuário  

### 4. **Consultas com Spring Data**
- Query Methods
- Anotação `@Query`
- Consultas com múltiplos critérios (ex.: texto e intervalo de datas)

---

## 🚀 Como Executar o Projeto

### 1. Clonar o repositório
```bash
git clone https://github.com/seu-usuario/workshop-springboot-mongodb.git
cd workshop-springboot-mongodb
```

### 2. Iniciar o MongoDB
Crie a pasta padrão de dados:
```bash
C:\data\db
```
E execute:
```bash
mongod
```

### 3. Configurar o arquivo `application.properties`
```properties
spring.data.mongodb.uri=mongodb://localhost:27017/workshop_mongo
server.port=8080
```

### 4. Executar o projeto
```bash
mvn spring-boot:run
```

Acesse o projeto em:  
👉 [http://localhost:8080/users](http://localhost:8080/users)

---

## 📚 Endpoints Principais

| Método | Endpoint | Descrição |
|--------|-----------|------------|
| GET | `/users` | Lista todos os usuários |
| GET | `/users/{id}` | Busca usuário por ID |
| POST | `/users` | Cria um novo usuário |
| PUT | `/users/{id}` | Atualiza usuário |
| DELETE | `/users/{id}` | Remove usuário |
| GET | `/users/{id}/posts` | Retorna os posts de um usuário |
| GET | `/posts/{id}` | Retorna um post por ID |
| GET | `/posts/titlesearch?text=` | Busca posts por título |
| GET | `/posts/fullsearch?text=&minDate=&maxDate=` | Busca posts por múltiplos critérios |

---

## 🧾 Exemplo de Documento no MongoDB

```json
{
  "id": "1001",
  "name": "Maria Brown",
  "email": "maria@gmail.com",
  "posts": [
    {
      "date": "2018-03-21",
      "title": "Partiu viagem",
      "body": "Vou viajar para São Paulo. Abraços!",
      "comments": [
        {
          "text": "Boa viagem mano!",
          "date": "2018-03-21",
          "author": { "id": "1013", "name": "Alex Green" }
        },
        {
          "text": "Aproveite!",
          "date": "2018-03-22",
          "author": { "id": "1027", "name": "Bob Grey" }
        }
      ]
    }
  ]
}
```

---

## 💡 Dicas e Solução de Problemas

- Caso apareça o erro **“invalid LOC header”** do Maven, apague os arquivos `.m2/repository` e deixe o Maven refazer o download.
- Para compatibilidade com Spring Boot 2.x.x:
  - Use `repo.saveAll()` ao invés de `repo.save()`
  - Use `Optional<User>` no método `findById`
  - Use `repo.deleteById(id)` para deleções

---

## 📺 Referências

- Curso: [Programação Orientada a Objetos com Java – Nelio Alves](http://educandoweb.com.br)
- Spring Boot Docs: https://docs.spring.io/spring-boot/
- MongoDB Docs: https://docs.mongodb.com/
- GitHub Original:  
  - Spring Boot 1.5.x: https://github.com/acenelio/workshop-spring-boot-mongodb  
  - Spring Boot 2.x.x: https://github.com/acenelio/workshop-springboot2-mongodb  

---

## 🧑‍💻 Autor

**Rafael Kmohan Paulino Patricio**  
📘 Projeto educacional baseado no material de apoio do Prof. Nelio Alves  
🔗 [GitHub](https://github.com/r121990)
