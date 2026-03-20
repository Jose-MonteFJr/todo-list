# 📝 Liferay To-Do List App

Um portlet de gerenciamento de tarefas (To-Do List) desenvolvido para Liferay DXP/Portal, utilizando a arquitetura MVC
Portlet e o Service Builder. Este projeto permite a criação de tarefas, gerenciamento de subtarefas (checklists) e anexo
de imagens utilizando a Liferay Document Library nativa.

## ✨ Funcionalidades

* **Gerenciamento de Tarefas:** Criação, edição, exclusão e alteração de status (Pendente/Concluída).
* **Checklists (Subtarefas):** Adição de subtarefas vinculadas a uma tarefa principal, com controle de status individual
  e edição rápida in-line.
* **Anexos de Imagem:** Upload, visualização, substituição e exclusão de imagens vinculadas às tarefas, exibidas
  diretamente na listagem.
* **Segurança Integrada:** Proteção contra ataques CSRF nativa, com injeção explícita do token de autenticação (
  `p_auth`) nas requisições do portlet.

## 🛠 Tecnologias e Ambiente

* **Liferay Workspace** (Gradle)
* **Java** (Compatível com Liferay 7.x)
* **Liferay MVC Portlet** & **Service Builder**
* **PostgreSQL**
* **Docker & Docker Compose**
* **Sistema Operacional:** Linux

## 🚀 Instruções de Instalação e Configuração

Este projeto foi configurado para rodar em um ambiente conteinerizado. Siga os passos abaixo para subir a
infraestrutura:

1. **Configurar permissões do banco de dados:**
   Como o PostgreSQL roda via Docker e persiste os dados localmente, garanta que o contêiner tenha permissão de escrita
   no volume mapeado na máquina host:

   ```bash
   sudo chown -R 999:999 postgres_data/
   ```

2. **Subir a Infraestrutura (Liferay + PostgreSQL):**

   ```bash
   docker compose up -d
   ```

## 📦 Passos para Compilar e Executar o Portlet

No desenvolvimento com Liferay OSGi, a ordem de deploy dos módulos é fundamental para evitar falhas de dependência e
travamentos no contêiner (como o status `STOPPED`).

1. **Gere os pacotes `.jar` na raiz do seu Liferay Workspace:**

   ```bash
   ./gradlew clean jar
   ```

2. **Realize o deploy sequencial:**
   Copie um módulo por vez para a pasta `deploy` e **aguarde a mensagem de `STARTED`** no log do Tomcat (
   `docker logs -f <nome_do_container>`) antes de enviar o próximo:

   *1º - API:*
   ```bash
   cp modules/todo/todo-api/build/libs/*.jar bundles/deploy/
   ```

   *2º - Service:*
   ```bash
   cp modules/todo/todo-service/build/libs/*.jar bundles/deploy/
   ```

   *3º - Web (Portlet):*
   ```bash
   cp modules/todo-web/build/libs/*.jar bundles/deploy/
   ```

Após o deploy bem-sucedido dos três módulos, o portlet estará disponível para ser adicionado em qualquer página de
conteúdo através do menu de Widgets do Liferay.

## 🏗 Decisões Técnicas e Arquitetura

* **Arquitetura Modular OSGi:** O projeto foi dividido em três módulos separados (`api`, `service` e `web`) para
  garantir baixo acoplamento. A camada de apresentação (`web`) consome exclusivamente as interfaces da `api`, sem
  acessar o banco de dados ou a implementação do serviço diretamente.
* **Liferay Service Builder (ORM):** Utilizado para gerar a camada de persistência. O Service Builder gerencia as
  tabelas no PostgreSQL através do arquivo `service.xml`.
    * *Tabelas mapeadas:* `Todo_Task`, `Todo_SubTask` e `Todo_TaskAttachment`.
* **Armazenamento de Arquivos (Document Library):** O upload de imagens não salva os binários em base de dados (BLOB).
  Utilizamos a `DLAppLocalServiceUtil` nativa do Liferay para persistir as imagens no repositório oficial do portal.
  Isso garante melhor performance, controle de versão, aproveitamento do cache do Liferay e facilidade na renderização
  das imagens na tela (`view.jsp`).
* **Segurança e CSRF:** Devido às rigorosas restrições de segurança do `SecurityPortletContainerWrapper` do Liferay, foi
  implementada a injeção do token `p_auth` gerado via `AuthTokenUtil.getToken(request)`. Isso garante que formulários e
  links de ação (`<portlet:actionURL>`) não sejam bloqueados pelo portal.
* **Documentação do Código:** O código fonte segue o padrão de documentação Javadoc nas classes de serviço (
  `LocalServiceImpl`) e nos controladores (`Portlet`), focando em explicar o "porquê" das integrações com as APIs
  nativas do Liferay.