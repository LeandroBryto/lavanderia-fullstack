 **sistema  de gerenciamento de pedidos**

## **Estrutura do Projeto**   Backend em Spring Boot /Frontend em Angular

```
/sistema-lavanderia
│── backend/                   # Backend em Spring Boot
│   ├── src/main/java/com/rs/lavanderia
│   │   ├── controller/        # Controllers (API REST)
│   │   ├── service/           # Regras de negócio
│   │   ├── repository/        # Acesso ao banco (JPA)
│   │   ├── model/             # Entidades do banco
│   │   ├── dto/               # Objetos de transferência de dados
│   │   ├── config/            # Configuração (CORS, Security, Actuator, Swagger)
│   │   ├── exception/         # Tratamento de exceções globais
│   │   
│   │   ├── util/              # Classes utilitárias (Formatadores, validadores)
│   │   ├── scheduler/         # Tarefas agendadas (Spring Scheduler)
│   ├── src/main/resources/
│   │   ├── application.properties  # Configuração do banco e servidor
│   │   ├── application-dev.properties  # Configuração para ambiente de desenvolvimento
│   │   ├── application-prod.properties # Configuração para ambiente de produção
│   ├── src/test/              # Testes unitários e de integração
│   │   ├── java/com/rs/lavanderia
│   │   │   ├── controller/    # Testes de controllers
│   │   │   ├── service/       # Testes de serviços
│   │   │   ├── repository/    # Testes de repositórios
│   ├── pom.xml                # Dependências do Maven
│
│── frontend/                   # Frontend em Angular
│   ├── src/
│   │   ├── app/
│   │   │   ├── components/      # Componentes reutilizáveis
│   │   │   ├── pages/           # Páginas principais
│   │   │   ├── services/        # Serviços para consumo de API
│   │   │   ├── models/          # Modelos de dados
│   │   │   ├── guards/          # Autenticação e segurança
│   │   │   ├── interceptors/    # Interceptors para requisições HTTP
│   │   │   ├── state/           # Gerenciamento de estado (NgRx, Akita)
│   │   │   ├── validators/      # Validações de formulários
│   │   │   ├── app-routing.module.ts  # Configuração de rotas
│   │   ├── assets/              # Ícones, imagens
│   │   ├── environments/        # Configurações de ambiente (dev, prod)
│   │   ├── styles.scss          # Estilos globais
│   ├── angular.json             # Configuração do Angular CLI
│   ├── package.json             # Dependências do Node.js
│   ├── karma.conf.js            # Configuração do Karma para testes
│   ├── protractor.conf.js       # Configuração do Protractor para testes E2E
│
│── docker-compose.yml           # Configuração com Docker
│── README.md                    # Documentação do projeto
│── .github/                     # Configurações de CI/CD (GitHub Actions)
│── scripts/                     # Scripts úteis para deploy, etc.
```

---

## **📌 Tecnologias Utilizadas**

### **Backend (Spring Boot)**

✅ Spring Boot 3 (Spring Web, JPA, Actuator)

✅ Banco de Dados MySQL

✅ Spring Boot Actuator (Monitoramento)

✅ Swagger/OpenAPI (Documentação da API)

✅ Spring Scheduler (Tarefas agendadas)

✅ Testes com JUnit e Mockito

### **Frontend (Angular)**

✅ Angular 17+

✅ Angular Material / PrimeNG para UI

✅ Angular Router (Rotas com Lazy Loading)

✅ Serviços e Interceptors (Consumo de API)

✅ RxJS (Programação reativa)

✅ NgRx ou Akita (Gerenciamento de estado)

✅ Testes com Jasmine, Karma e Protractor

---

## **📌 Funcionalidades**

### **Backend**

✅ **API REST** para listar, adicionar, atualizar e excluir pedidos

✅ **Monitoramento** com Spring Boot Actuator

✅ **Documentação da API** com Swagger/OpenAPI

✅ **Tratamento de exceções** global

✅ **Tarefas agendadas** para processos em segundo plano

### **Frontend**

✅ **Frontend modularizado** com Angular Components

✅ **Rotas configuradas** com Lazy Loading

✅ **Serviços para comunicação** entre frontend e backend

✅ **Validação de formulários** reativa

✅ **Feedback ao usuário** com mensagens de sucesso/erro

✅ **Gerenciamento de estado** com NgRx ou Akita

## **📌 Descrição do Projeto**

O sistema de lavanderia permitirá que os usuários:

1. **Cadastrem pedidos de lavagem** (roupas, tipos de serviço, prazos, etc.).
2. **Acompanhem o status dos pedidos** (em andamento, concluído, entregue).
3. **Visualizem histórico de pedidos**.
4. **Recebam notificações** sobre atualizações de status.

---

## **📌 Fluxo do Sistema**

### **1. Fluxo Principal (Backend e Frontend)**

### **Backend (Spring Boot)**

- **Controller**: Recebe as requisições HTTP do frontend e as encaminha para o Service.
- **Service**: Contém a lógica de negócio (validações, regras de negócio, etc.).
- **Repository**: Faz a comunicação com o banco de dados (CRUD).
- **Model**: Representa as entidades do banco de dados (Pedido, Cliente, Serviço, etc.).
- **DTO**: Objetos de transferência de dados para comunicação entre frontend e backend.
- **Exception**: Trata exceções globais (erros de validação, erros de banco de dados, etc.).
- **Scheduler**: Executa tarefas agendadas (ex.: notificações de pedidos atrasados).

### **Frontend (Angular)**

- **Components**: Componentes reutilizáveis (ex.: formulário de pedido, lista de pedidos).
- **Pages**: Páginas principais (ex.: página de cadastro de pedidos, página de histórico).
- **Services**: Serviços para consumir a API do backend.
- **Models**: Modelos de dados que refletem os DTOs do backend.
- **Interceptors**: Interceptadores para adicionar headers ou tratar erros globais.
- **State**: Gerenciamento de estado (ex.: NgRx para armazenar o estado dos pedidos).
- **Routing**: Configuração de rotas com Lazy Loading. ,  nao usei Documentação da API com Swagger/OpenAPI
