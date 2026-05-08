# 🎸 Rock Wear E-commerce

Este projeto consiste em um sistema de gerenciamento de produtos desenvolvido em **Java** para a loja de roupas e acessórios **ROCK WEAR**. O sistema opera via console (CLI), permitindo o controle completo do inventário através de operações de CRUD (Criar, Ler, Atualizar e Deletar).

Este repositório é fruto do **Teste Técnico do Bloco 01** realizado para o curso de **Java Full Stack** da **Generation Brasil**.

---

## 🚀 Funcionalidades

O sistema foi estruturado para suportar diferentes tipos de produtos, aplicando conceitos de Herança e Polimorfismo:

* **Cadastrar Produto**: Suporta categorias de Roupas (com atributo tecido) e Acessórios (com atributo material).
* **Listar Todos**: Exibição formatada de todos os itens em estoque.
* **Atualizar Produto**: Edição de dados de produtos existentes via ID.
* **Excluir Produto**: Remoção de itens do sistema.
* **Buscar por Categoria**: Filtro específico para agilizar a consulta de tipos de produtos.

---

## 🛠️ Tecnologias e Conceitos Utilizados

* **Linguagem:** Java 17
* **IDE:** Spring Tool Suite (STS) 4
* **Conceitos de POO:**
* Abstração e Herança
* Encapsulamento
* Polimorfismo
* Interfaces e Repositórios
* Collections (ArrayList)



---

## 📂 Estrutura do Projeto

```bash
ecommerce/
├── src/
│   └── ecommerce/
│       ├── Menu.java                 # Classe principal (Interface do Usuário)
│       ├── controller/
│       │   └── ProdutoController.java    # Lógica de negócio e gestão de dados
│       ├── model/
│       │   ├── Produto.java             # Classe abstrata base
│       │   ├── ProdutoRoupa.java        # Especialização para vestuário
│       │   └── ProdutoAcessorio.java    # Especialização para acessórios
│       ├── repository/
│       │   └── ProdutoRepository.java    # Contrato das operações (Interface)
│       └── util/
│           └── Cores.java               # Customização visual do console
└── bin/                              # Binários compilados

```

---

## ⚙️ Como Executar

### Pré-requisitos

* **Java JDK 17** instalado.
* Uma IDE (recomendado **Spring Tool Suite 4**) ou terminal.

### Via Terminal

1. Clone o repositório:
```bash
git clone https://github.com/Eliane-orlandin/projeto_final_bloco_01.git

```


2. Compile o projeto:
```bash
javac -d bin src/ecommerce/*.java src/ecommerce/*/*.java

```


3. Execute a aplicação:
```bash
java -cp bin ecommerce.Menu

```



### Via Spring Tool Suite (STS)

1. Importe o projeto como `Existing Projects into Workspace`.
2. Certifique-se de que o **JRE System Library** está configurado para o Java 17.
3. Clique com o botão direito em `Menu.java` > `Run As` > `Java Application`.

---

## 👤 Sobre a Autora

**Eliane Orlandin do Carmo** 

🎓 Tecnóloga em Análise e Desenvolvimento de Sistemas (Estácio)

🌱 Desenvolvedora Full Stack em formação pela Generation Brasil

<div>
  <a href="https://www.linkedin.com/in/eliane-orlandin-do-carmo-551b92246/" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a>
  <a href = "mailto:liorlandin33@gmail.com"><img src="https://img.shields.io/badge/-Gmail-%23333?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
</div>

---

*Este projeto foi desenvolvido com foco em lógica de programação e fundamentos de Java.*
