
# Desafio NekiCard - Spring Boot - Java API

### API Desenvolvida para o DesafioNeki - Aplicando conhecimentos adquiridos durante a trilha de preparação

## Technologies:

- [Sprint Tool Suite 4](https://spring.io/tools)
- [Postgres](https://www.postgresql.org/download/)
- [Dbeaver](https://dbeaver.io/download/)
- [Insomnia](https://insomnia.rest/download)
- [Swagger](https://swagger.io/tools/swagger-ui/download/)
- [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) 
- [Hibernate](https://hibernate.org)
- [JPA](https://openjpa.apache.org/downloads.html)


## Endpoints

### Cadastro
- Descrição: Adiciona um novo colaborador ao sistema.
- Método HTTP: POST
- Endpoint: /signUp
- Corpo da Requisição: Objeto CollaboratorRegistrationData
- Resposta: Retorna os detalhes do novo colaborador registrado.

### Envio de Foto

- Descrição: Salva a foto de avatar de um colaborador, responsável por salvar a imagem em um diretório do computador.
- Método HTTP: POST
- Endpoint: ``/photo/{email}``
- Parâmetros da Requisição:
    - photo: MultipartFile - A foto de avatar a ser enviada.
    - email: O email do colaborador para associar à foto.
- Resposta: Retorna uma mensagem de sucesso após salvar o avatar.

### Atualização de Colaborador

- Descrição: Atualiza as informações de um colaborador por ID.
- Método HTTP: PUT
- Endpoint: ``/update/{id}``
- Segurança: Requer um token Bearer válido para autenticação. Apenas acessível por usuários com a função 'ADMINISTRADOR'.
- Corpo da Requisição: Objeto CollaboratorUpdateData
- Parâmetro do Caminho (Path Parameter): id - O ID do colaborador a ser atualizado.
- Resposta: Retorna os detalhes atualizados do colaborador.

### Exclusão de Colaborador

- Descrição: Exclui um colaborador por ID, tornando-o inativo no sistema.
- Método HTTP: DELETE
- Endpoint: ``/delete/{id}``
- Segurança: Requer um token Bearer válido para autenticação. Apenas acessível por usuários com a função 'ADMINISTRADOR'.
- Parâmetro do Caminho (Path Parameter): id - O ID do colaborador a ser excluído.
- Resposta: Retorna os detalhes do colaborador excluído.

### Encontrar Colaborador por ID

- Descrição: Recupera as informações de um colaborador por ID.
- Método HTTP: GET
- Endpoint: `/{id}`
- Parâmetro do Caminho (Path Parameter): id - O ID do colaborador a ser recuperado.
- Resposta: Retorna os detalhes do colaborador com o ID especificado.

### Encontrar Todos os Colaboradores Ativos

- Descrição: Recupera todos os colaboradores ativos no sistema.
- Método HTTP: GET
- Endpoint: ``/findAll/active``
- Segurança: Requer um token Bearer válido para autenticação. Apenas acessível por usuários com a função 'ADMINISTRADOR'.
- Resposta: Retorna uma lista de detalhes de todos os colaboradores ativos no sistema.

## Autenticação JWT

- A API utiliza a autenticação JWT (JSON Web Tokens) para garantir a segurança das rotas. Para acessar as rotas protegidas, você precisará enviar um token JWT válido no cabeçalho da requisição HTTP. O token JWT deve ser obtido através da rota de autenticação, fornecendo credenciais válidas.




## Stack utilizada



**Back-end:** Spring Boot 3, Java 17



## Screenshots

![App Screenshot](https://i.imgur.com/SexbXQH.png)

