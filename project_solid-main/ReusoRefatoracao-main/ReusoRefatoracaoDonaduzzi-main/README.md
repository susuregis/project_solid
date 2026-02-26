# SolidProject

## Descrição

SolidProject é uma aplicação Spring Boot que implementa os princípios SOLID de design orientado a objetos. O projeto demonstra boas práticas de engenharia de software através de um sistema de gerenciamento de usuários com suporte a diferentes categorias (usuário comum e VIP) e funcionalidades de desconto e notificação por email.

## Tecnologias Utilizadas

- **Java 21**: Linguagem de programação
- **Spring Boot 4.0.2**: Framework para desenvolvimento de aplicações
- **Spring Data JPA**: Camada de persistência de dados
- **Spring Mail**: Integração com serviços de email
- **H2 Database**: Banco de dados em memória para desenvolvimento
- **Maven**: Gerenciador de dependências e build

## Estrutura do Projeto

```
src/main/
├── java/br/com/nogueiranogueira/aularefatoracao/solidproject/
│   ├── SolidprojectApplication.java          # Classe principal da aplicação
│   ├── controller/                            # Camada de controle
│   │   ├── UsuarioController.java
│   │   └── GerenciadorUsuarioController.java
│   ├── service/                               # Camada de negócio
│   │   ├── UsuarioService.java
│   │   ├── DescontoService.java
│   │   ├── EmailService.java
│   │   ├── SmtpEmailService.java
│   │   ├── UsuarioMailSenderService.java
│   │   └── GerenciadorUsuarioService.java
│   ├── model/                                 # Modelos de domínio
│   │   ├── Usuario.java
│   │   ├── UsuarioVIP.java
│   │   ├── RegraUsuario.java
│   │   ├── RegraUsuarioComum.java
│   │   └── RegraUsuarioVIP.java
│   ├── dto/                                   # Objetos de transferência de dados
│   │   └── UsuarioDTO.java
│   └── repository/                            # Camada de acesso a dados
│       ├── UsuarioRepository.java
│       ├── UsuarioRelatorioRepository.java
│       ├── GerenciadorUsuarioRepository.java
│       └── GerenciadorUsuarioRepositoryImpl.java
├── resources/
│   └── application.yaml                       # Configurações da aplicação
```

## Funcionalidades

### Gerenciamento de Usuários

- Criação e gerenciamento de usuários com diferentes tipos (comum e VIP)
- Aplicação de regras de negócio específicas por tipo de usuário
- Cálculo automático de descontos baseado no tipo de usuário

### Sistema de Descontos

- Serviço dedicado para cálculo de descontos individuais e totais
- Suporte a diferentes estratégias de desconto por tipo de usuário
- Acumulação de pontos de fidelidade

### Notificações por Email

- Integração com serviços de email SMTP
- Envio de notificações através do serviço `UsuarioMailSenderService`
- Configuração flexível de credenciais de email

## Como Executar

### Pré-requisitos

- Java Development Kit (JDK) versão 21 ou superior
- Maven 3.6 ou superior

### Instalação e Execução

1. Clone o repositório:
```bash
git clone <url-do-repositorio>
cd ReusoRefatoracaoDonaduzzi-main
```

2. Compile o projeto:
```bash
mvn clean compile
```

3. Execute a aplicação:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080`

### Executar Testes

```bash
mvn test
```

## Configuração

### Arquivo application.yaml

Edite o arquivo `src/main/resources/application.yaml` para configurar:

- Banco de dados
- Serviço de email SMTP
- Porta da aplicação

Exemplo de configuração de email:
```yaml
spring:
  mail:
    host: smtp.example.com
    port: 587
    username: seu_usuario
    password: sua_senha
    properties:
      mail:
        smtp:
          auth: true
          starttls:
            enable: true
```

## API REST

### Endpoints Disponíveis

- `GET /usuario` - Lista todos os usuários
- `POST /usuario` - Cria um novo usuário
- `GET /usuario/{id}` - Obtém um usuário específico
- `PUT /usuario/{id}` - Atualiza um usuário
- `DELETE /usuario/{id}` - Deleta um usuário

- `GET /gerenciador-usuario` - Lista gerenciamento de usuários
- `POST /gerenciador-usuario` - Gerencia usuários

## Princípios SOLID Implementados

O projeto demonstra a aplicação dos seguintes princípios:

- **Single Responsibility Principle (SRP)**: Cada classe tem uma responsabilidade bem definida
- **Open/Closed Principle (OCP)**: Classes abertas para extensão, fechadas para modificação
- **Liskov Substitution Principle (LSP)**: Subclasses podem substituir suas superclasses
- **Interface Segregation Principle (ISP)**: Interfaces específicas e bem definidas
- **Dependency Inversion Principle (DIP)**: Dependência de abstrações, não de implementações concretas

