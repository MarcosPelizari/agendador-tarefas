
# Project Title

A brief description of what this project does and who it's for

# API de Agendador de Tarefas

## Descrição
A API de Agendador de Tarefas é uma aplicação Java com Spring Boot que gerencia o agendamento e manipulação de tarefas. Ela permite criar, buscar, atualizar, deletar e alterar o status de tarefas, integrando-se com a API de Usuários para autenticação via JWT e usando MongoDB para persistência de dados.

## Pré-requisitos
- **Java**: 17 ou superior
- **Gradle**: 8.x (usado para gerenciar dependências)
- **MongoDB**: 8.x (banco de dados NoSQL para armazenar tarefas)
- **API de Usuários**: Deve estar rodando em `http://localhost:8080` para autenticação
- **IntelliJ IDEA** (opcional, recomendado para desenvolvimento)
- **Postman** (recomendado para testar os endpoints)

## Instalação
1. **Clone o Repositório**:
   ```bash
   git clone https://github.com/seu-usuario/agendador-tarefas.git
   cd agendador-tarefas
   ```

2. **Configure o MongoDB**:
  - Certifique-se de que o MongoDB está rodando localmente na porta padrão 27017.

  - Não é necessário criar o banco manualmente; o Spring Data MongoDB criará o banco db_agendador automaticamente.

  - Verifique as configurações no arquivo `src/main/resources/application.properties`:
  ```
  spring.application.name=agendador-tarefas
spring.data.mongodb.uri=mongodb://localhost:27017/db_agendador
usuario.url=http://localhost:8080
server.port=8081
```

## Endpoints
- **POST /tarefas**  
  Grava uma nova tarefa (requer token).  
  **Header**:
  - `key`: Authorization
  - `value`: <seu_token>

**Nota**: Não inclua o prefixo "Bearer" no token.  
**Body**:
```json
{
  "titulo": "Reunião de Equipe",
  "descricao": "Reunião para discutir o projeto X",
  "dataInicio": "2025-04-05T10:00:00",
  "dataFim": "2025-04-05T11:00:00",
  "email": "joao.silva@exemplo.com",
  "status": "PENDENTE"
}
```

- **GET /tarefas**  
  Busca tarefas por email (requer token).  
  **Header**:
  - `key`: Authorization
  - `value`: <seu_token>
