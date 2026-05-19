# 🎸 Rock Wear E-commerce
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-orange?style=for-the-badge)

Este projeto consiste em um sistema de gerenciamento de produtos desenvolvido em **Java** para a loja de roupas e acessórios **ROCK WEAR**. O sistema opera via console (CLI), permitindo o controle completo do inventário através de operações de CRUD (Criar, Ler, Atualizar e Deletar).

> **🔄 Projeto em Evolução:** Este repositório nasceu como o **Teste Técnico do Bloco 01** no curso **Java Full Stack da Generation Brasil**. Originalmente, o projeto utilizava dados em memória (Collections). Atualmente, o sistema está sendo expandido e integrado com novas tecnologias conforme o meu avanço no curso.

---

## 🗺️ Roadmap de Evolução

- [x] **Fase 1:** Estrutura básica Java CLI, POO e persistência em memória (Collections).
- [x] **Fase 2:** Modelagem de Banco de Dados Relacional e persistência real com **SQL e JDBC**.
- [ ] **Fase 3:** Migração para uma API RESTful utilizando **Spring Boot** (Backend).
- [ ] **Fase 4:** Construção de uma interface web moderna (Frontend).

---

## 🚀 Funcionalidades Atuais

O sistema foi estruturado para suportar diferentes tipos de produtos, aplicando conceitos sólidos de POO e persistência em banco de dados:

* **Cadastrar Produto**: Suporta categorias de Roupas (com atributo tecido) e Acessórios (com atributo material).
* **Listar Todos**: Exibição formatada de todos os itens cadastrados diretamente no banco de dados.
* **Atualizar Produto**: Edição de dados de produtos existentes via ID.
* **Excluir Produto**: Remoção física de itens do sistema.
* **Buscar por Categoria**: Filtro específico para agilizar a consulta de tipos de produtos.

---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem Principal:** Java 17
* **Banco de Dados:** SQL (MySQL )
* **Conexão com Banco:** JDBC (Java Database Connectivity)
* **IDE:** Spring Tool Suite (STS) 4
* **Conceitos de POO Aplicados:**
  * Abstração e Herança
  * Encapsulamento e Polimorfismo
  * Interfaces e Padrão Repository

---

## 📂 Estrutura do Projeto

```bash
ecommerce/
├── src/
│   └── ecommerce/
│       ├── Menu.java                  # Classe principal (Interface do Usuário no Console)
│       ├── controller/                # Camada de controle 
│       │   └── ProdutoController.java # Lógica de negócio e gestão de dados
│       ├── model/                     # Camada de entidades (POO)
│       │   ├── Produto.java           # Classe abstrata base
│       │   ├── ProdutoRoupa.java      # Especialização para vestuário
│       │   └── ProdutoAcessorio.java  # Especialização para acessórios
│       ├── repository/                # Camada de persistência
│       │   ├── ProdutoRepository.java # Contrato das operações (Interface)
│       │   └── ProdutoRepositoryJDBC.java # Implementação das consultas em SQL via JDBC
│       └── util/                      # Utilitários do projeto
│           ├── ConectionFactory.java  # Gerenciamento de conexão com o banco de dados
│           └── Cores.java             # Customização visual do console
├── docs/                              # Documentação e modelagem
│   ├── schema.sql                     # Script SQL de criação das tabelas
│   └── DER_db_rockwear.png            # Diagrama Entidade-Relacionamento (DER)
└── bin/                               # Binários compilados
```
---
## ⚙️ Como Executar

### Pré-requisitos

* **Java JDK 17** instalado.
* **Sistema Gerenciador de Banco de Dados (SGBD)** instalado (Ex: MySQL).
* Uma IDE (Recomendado: **Spring Tool Suite 4** ou **VS Code**) ou terminal.


---

### 🗄️ 1. Configurando o Banco de Dados

Antes de rodar a aplicação Java, você precisa preparar o banco de dados:

1. Abra o seu gerenciador de banco de dados (ex: MySQL Workbench, DBeaver, etc).
2. Execute o script SQL localizado em `docs/schema.sql` para criar o banco de dados e as tabelas necessárias.
3. Certifique-se de que o arquivo `DER_db_rockwear.png` reflete a estrutura criada.
4. *(Opcional)* Se necessário, ajuste as credenciais de login (`user` e `password`) dentro do arquivo `ConectionFactory.java` para corresponderem ao seu ambiente local.

---

### 💻 2. Executando a Aplicação

#### Via Terminal

1. Clone o repositório:
```
git clone [https://github.com/Eliane-orlandin/projeto_final_bloco_01.git](https://github.com/Eliane-orlandin/projeto_final_bloco_01.git)
```

2. Compile o projeto:
```
javac -d bin src/ecommerce/*.java src/ecommerce/*/*.java
```

3. Execute a aplicação:
```
java -cp bin ecommerce.Menu
```
#### Via Spring Tool Suite (STS)

1. Importe o projeto como `Existing Projects into Workspace`.
2. Certifique-se de que o **JRE System Library** está configurado para o **Java 17**.
3. Clique com o botão direito em `Menu.java` ➡️ **Run As** ➡️ **Java Application**.

---

## 👤 Sobre a Autora

**Eliane Orlandin do Carmo**  
🎓 Tecnóloga em Análise e Desenvolvimento de Sistemas (Estácio)  
🌱 Desenvolvedora Full Stack em formação pela Generation Brasil

---

*Este projeto está em constante evolução, servindo como laboratório prático para a aplicação de novas tecnologias de desenvolvimento de software.*
