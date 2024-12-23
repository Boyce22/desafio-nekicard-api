# NekiCard - API 🛠️  

### Gerencie colaboradores de forma prática e eficiente com funcionalidades avançadas, como cadastro, atualização e upload de avatares, garantindo segurança e agilidade no acesso.  

---

## ⚙️ Funcionalidades  

### ✍️ **Cadastro de Colaborador**  
- Permite o cadastro de novos colaboradores utilizando os parâmetros fornecidos na aplicação.  

### 📷 **Upload de Avatar**  
- Envio de **imagens de perfil** que são armazenadas com segurança em um diretório definido.  

### ✏️ **Atualização de Dados do Colaborador**  
- Atualização dos dados de colaboradores cadastrados utilizando o **ID**.  
- O recurso é restrito a **administradores autenticados**.  

### ❌ **Exclusão de Colaborador**  
- Torna o colaborador inativo no sistema ajustando o estado de **`isActive`**.  
- Apenas administradores autenticados têm permissão para realizar essa ação.  

### 🧐 **Busca de Colaborador por ID**  
- Recupera os **dados completos** de um colaborador específico utilizando seu **ID**.  

### 📋 **Listagem de Colaboradores Ativos**  
- Retorna uma lista completa de todos os colaboradores ativos no sistema.  
- Função disponível exclusivamente para **administradores autenticados**.  

---

## 🛠️ Tecnologias Utilizadas  

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) ☕ - Linguagem moderna e eficiente.  
- [Spring Framework](https://spring.io/) 💚 - Framework robusto para criar APIs corporativas.  
- [PostgreSQL](https://www.postgresql.org/) 📓 - Banco de dados relacional de alta performance.  
- [Swagger](https://swagger.io/) 📖 - Ferramenta para documentação interativa e visualização de endpoints.  
- [JWT](https://jwt.io/) 🔒 - Implementação para autenticação segura via token.  
- [Maven](https://maven.apache.org/) ⚖️ - Gerenciador de dependências e automação de builds.  

---

## 📦 Dependências  

| Dependência              | Link                                                                                   |  
|--------------------------|----------------------------------------------------------------------------------------|  
| **Lombok**               | [Lombok Setup](https://projectlombok.org/setup/maven)                                  |  
| **PostgreSQL**           | [PostgreSQL Driver](https://mvnrepository.com/artifact/org.postgresql/postgresql)      |  
| **Spring Validation**    | [Spring Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation)|  

---

## 🚀 Instalação  

### 🗄️ Configurações do Banco de Dados  

1. **Abra o arquivo** `application.properties` na pasta do projeto.  
2. Substitua as configurações padrão com as informações do seu banco de dados PostgreSQL:  

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/nekicard
spring.datasource.username=seu_usuario  
spring.datasource.password=sua_senha
```

3. Verifique o driver do banco de dados:  

```properties
spring.datasource.driverClassName=org.postgresql.Driver
```

4. Configure o Hibernate para gerenciar o esquema automaticamente:  

```properties
spring.jpa.hibernate.ddl-auto=update
```

5. Defina o **dialeto do Hibernate** para PostgreSQL:  

```properties
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

---

### ▶️ Inicializando o Sistema  

1. Certifique-se de que o PostgreSQL está rodando no ambiente local.  
2. Compile e execute a aplicação utilizando sua IDE ou os comandos do Maven:  

```shell script
mvn spring-boot:run
```

3. Utilize ferramentas como **Postman** ou **Insomnia** para testar os endpoints disponibilizados.  
4. Acesse a documentação interativa do Swagger no seguinte endereço:  

```
http://localhost:8080/swagger-ui.html
```

---

## 📸 Swagger  

O **NekiCard API** conta com uma interface interativa e intuitiva gerada pelo Swagger para testes e navegação pelos endpoints.  

![Swagger Interface](https://i.imgur.com/SexbXQH.png)  

---

## 📝 Notas Adicionais  

- O sistema foi desenvolvido em um prazo de **2 dias**, focando em eficiência e qualidade técnica!  
- Substitua `seu_usuario` e `sua_senha` pelas credenciais apropriadas ao seu ambiente do PostgreSQL.  
- Caso necessário, ajuste as configurações padrões no arquivo `application.properties` para atender a demandas específicas.  

Este guia oferece o necessário para configurar e iniciar o **NekiCard API** com segurança e eficiência. 🚀  
