---
title: "Especificação do Sistema Aplicativo para Recomendação de Filmes, Séries e Livros"
author: "Prática Profissional em ADS"
---


**Índice**

- [1. Introdução](#1-introdução)
- [2. Informações sobre a empresa](#2-informações-sobre-a-empresa)
- [3. Escopo do projeto](#3-escopo-do-projeto)
- [4. Interessados](#4-interessados)
- [5. Requisitos Funcionais](#5-Requisitos-Funcionais)
- [6. Requisitos Não Funcionais](#6-Requisitos-Não-Funcionais)
- [7. Casos de uso](#7-casos-de-uso)
  <!-- - [7.1. Acessar funções restritas](#71-acessar-funções-restritas)
  - [7.2. Efetuar registro](#72-efetuar-registro)
  - [7.3. Efetuar seu próprio pedido](#73-efetuar-seu-próprio-pedido)
  - [7.4. Efetuar pedido para o cliente](#74-efetuar-pedido-para-o-cliente) -->
- [8. Diagrama de Sequência](#8-Diagrama-de-Sequência)
- [9. Diagrama de domínio](#9-Diagrama-de-domínio)
- [10. Diagrama de Classes](#10-Diagrama-de-Classes)
- [11. Wireframes](#11-Wireframes)


# 1. Introdução

Este documento é responsável pela especificação de um Sistema que gera recomendações de Livros, Séries e Filmes para seus usuarios. O Cortinas busca a interatividade entre seus colaboradores, tendo em vista que este,  atua quase como uma rede social, oferencendo uma plataforma com gererenciamento de amigos, avaliação de filmes, series e livros assim como seu cadastro, recomendações, e outras funcionalidades a serem desenvolvidas.

Este tambem, descreve os requisitos não-funcionais, modela os requisitos funcionais com casos de uso e modela os conceitos do domínio do problema.

# 2. Informações sobre a empresa

A Empresa *   * analisa o mercado digital, tendências e mudanças, e atua drasticamente no desenvolvimento de ambientes responsivos e inovadores que gerem interatividade entre seus colaboradores.
Atua tambem, no ambito socio-ambiental, tendo em vista que gera, com base em sua receita, investimentos na conscientização digital e no mercado de recursos e combustiveis renováveis.


# 3. Escopo do projeto

  Sistema Web que oferece á seus Usuários uma plataforma para adição, compartilhamento e interacao de Usuarios leitores, e/ou consumidores de Séries e Filmes.
  O projeto aborda de forma inovadora, como uma rede social, as contribuições e participações entre nossos colaboradores, isto é, abordaremos o Escopo prático, assim como
  Desenvolvimento, Especificação e Revisão. 
  No Desenvolvimento, trataremos também sobre questões de segurança de dados, implementando um algoritmo matematico que "embaralha" seu conteúdo e/ou o famoso Hash que mapeia dados grandes e de tamanho variavel e os transforma em dados pequenos de tamanho fixo.  

# 4. Interessados

  Usuário/Cliente: Qualquer pessoa da empresa, ou fora dela, pode se registrar nesta rede social. <br>
  Administrador de Conteúdo: Aquele que será responsável por validar itens adicionados pelos Usuários. <br>
  Administrador de Algoritmo: Ficará responsável por administrar o algoritmo que oferecera recomendações a um determinado membro. <br>
  Gerente de Serviço: Atualiza informações dos itens e dados cadastrais dos usuários. <br>
  Administrador de Segurança: Responsável pela segurança dos dados através de criptografia e tecnologias CloudComputing. <br>
  Desenvolvedores Front-End: Responsáveis pela Responsividade do Sistema, Layout, UX/UI. <br>
  Programadores: Responsáveis pela dinamizacao da Plataforma, integração Web com Banco de Dados, Nuvem, etc..



# 5. Requisitos Funcionais
|RF |  Descrição  |
| :---: | ------------------- |
|  1 |  O sistema deve permitir o login de um usuário, fornecendo nome completo, username, senha, data de nascimento, cidade e estado. |
|  2 |  O sistema deverá utilizar um algoritmo colaborativo para oferecer as recomendações a um determinado membro. Isto quer dizer que o sistema deverá identificar membros que têm um perfil semelhante com base nas avaliações já realizadas e oferecer recomendações com base no que estes membros avaliaram bem.|
|  3 |  Os dados nos perfis podem ser atualizados a qualquer momento. |
|  4 |  O sistema permitirá a avaliação de filmes, séries e livros pelos usuários. |
|  5 |  Após o cadastro de 10 membros e, após cada um deles enviarem 10 avaliações, o sistema começará a recomendar para os membros filmes, séries e livros que podem lhes interessar. |
|  6 |  Para cadastrar um filme, o usuário deverá cadastrar o título, diretor, elenco principal, país, ano. |
|  7 |  Para cadastrar uma série, o usuário deverá cadastrar o título, diretor, elenco principal, país, ano, número de temporadas. |
|  8 |  Para cadastrar um livro, o usuário deverá cadastrar o título, autor(es), editora, país, ano de lançamento  |
|  9 |  Os usuários têm suas páginas pessoais onde estão suas atividades. Os usuários podem pesquisar por outros usuários e acessar suas páginas. |
|  10 |  Os usuários podem fazer uma solicitação de amizade para os demais usuários. |
|  11 |  A amizade só será efetuada quando o usuário que a recebeu, confirmá-la. |
|  12 |  Os membros que possuem amizades efetuadas podem efetuar comentários as avaliações feitas pelo outro. |
|  13 |  Um membro poderá das um "joinha" nas avaliações de outro membro. Em cada avaliação aparecerá o número de "joinhas" que ela já recebeu. |
|  14 |  O membro que deu o “joinha” para a avaliação poderá retirá-lo posteriormente se assim desejar. |
|  15 |  A página pessoal de um membro mostrará, além das avaliações que ele fez, uma lista com os seus amigos e o número de recomendações que ele já recebeu. |
|  16 |  Quando um membro acessar a página de outro, o sistema deverá mostrar os amigos que eles têm em comum. |
|  17 |  Sempre que um membro acessar o sistema, ele deverá receber a sugestão de 3 membros que poderiam ser seus amigos. O critério será sugerir membros que têm preferências semelhantes, com base nas avaliações já realizadas. |
|  18 |  Cada filme, série e livro deverá ter uma página no sistema que reunirá todas as avaliações já realizadas daquele item, ordenadas pelo número de "joinhas" recebidos. |
|  19 |  Para realizar a avaliação, o sistema deverá suportar notas entre 0 a 10, comentários com limite de 1024 caracteres. |
|  20 |  A cada novo item cadastrado, este deve ser validado por um administrador de conteúdo antes de ser disponibilizado aos demais membros. |
|  21 |  Caso um item cadastrado já exista, o administrador de conteúdo indica o item e vincula a avalição ao item já existente. |
|  22 |  O sistema deverá permitir que o gerente do serviço consulte: a.	O número médio de amigos dos membros da rede social. b.	Uma lista com os 10 membros mais conectados (com o maior número de amigos). c.	Um gráfico mostrando a relação entre o número de amigos e o estado onde mora.|





# 6. Requisitos Não Funcionais 
|RNF |  Descrição  |
| :---: | ------------------- |
|  1 |  O sistema só poderá ser acessado pelo navegador do dispositivo móvel ou pelo computador. |
|  2 |  O sistema deve ser responsivo e leve, para evitar demora no carregamento. |
|  3 |  O sistema deve usar Base de Dados (Relacional ou NoSQL). |
|  4 |  O sistema deve ser implantado em um provedor de serviços (AWS, Azure, Google Cloud etc). |
|  5 |  O sistema deve ter um tempo de recarga de página não deve ser superior a 5 segundos. |
|  6 |  O sistema deverá atender o padrão 99.99% em regime 24/7. |
|  7 |  O sistema deverá apresentar indicativos de como seus dados estarão assegurados contra as invasões ao sistema. |




# 7. Casos de uso

**Casos de Usos divididos por cenários.** <br>

Cenário 01 - Cadastrar Novo Membro.
<p align="center">
<img src = "Diagramas/Casos de Uso/Cenario01 - Cadastrar Novo Membro.png">
 </p>

## 7.1. Fazer Registro

| **Objetivo:** | Especificar as etapas que um membro recém chegado a plataforma deve tomar para efetuar registro. |
| :---: | -------------------  |
| **Atores:** | Membro não registrado |
| **Pré-condições:** | Deverá fornecer seus dados corretamente como: Nome completo, username, senha, data de nascimento, cidade e estado. |
| **Pós-Condições:**  | O sistema mostra o membro já registrado. |
| **Fluxo Principal:** | a: O ator decide efetuar cadastro na plataforma <br> b: Insere os dados requisitados <br> c: O sistema valida os dados inseridos <br> d: O sistema retorna uma mensagem de conclusão de registro. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativa A:</strong> <br> a: O ator decide efetuar cadastro na plataforma <br> b: Insere os dados requisitados <br> c: O sistema verifica algum erro nos dados inseridos <br> d: O sistema encontra o erro <br> e: Retorna a letra b do Fluxo Principal para refazer o processo. <br><br> <strong>Fluxo Alternativa B: </strong> <br> a: O ator conclui com sucesso o cadastro e entra no sistema. <br> b: Procura o botão de acessar seus dados <br> c: Muda os dados de sua preferência <br> d: Verifica as modificações <br> e: Sistema valida os dados e confirma modificações. <br> <br> <strong>Fluxo Alternativa C:</strong> <br> a: O ator conclui com sucesso o cadastro e entra no sistema. <br> b: Procura o botão de acessar seus dados <br> c: Muda os dados de sua preferência <br> d: Verifica as modificações <br> e: Sistema invalida os dados e retorna para a letra b do Fluxo Alternativo C |


<hr>
Cenário 02 - Acessar Conta Cadastrada
<p align = "center">
<img src = "Diagramas/Casos de Uso/Cenario02 - Acessar Conta Cadastrada.png" >
</p>


# 8. Diagrama de Sequência




# 9. Diagrama de domínio






# 10. Diagrama de Classes



# 11. Wireframes
