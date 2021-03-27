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
  - [7.1.1 Fazer Registro](#711-Fazer-Registro)
  - [7.1.2 Fazer Login](#712-Fazer-Login)
  - [7.1.3 Sugere membros para serem amigos](#713-Sugere-membros-para-serem-amigos)
  - [7.1.4 Avaliar Filmes, Séries e Livros](#714-Avaliar-Filmes,-Séries-e-Livros) 
  - [7.1.5 Cadastrar Novo Item (Série, filmes, livros)](#715-acessar-funções-restritas)
  - [7.1.6 Validar Itens](#716-efetuar-registro)
  - [7.1.7 Apresentar Recomendações de Itens para cada membro](#717-efetuar-seu-próprio-pedido)
  - [7.1.8 Identificar Membros com perfil semelhante](#74-efetuar-pedido-para-o-cliente) 
  - [7.1.9 Pesquisar outros membros](#71-acessar-funções-restritas)
  - [7.2.1 Propor relacionamento de amizade](#72-efetuar-registro)
  - [7.2.2 Verificar pendências de amizade](#73-efetuar-seu-próprio-pedido)
  - [7.2.3 Listar avaliações realizadas pelo membro amigo](#74-efetuar-pedido-para-o-cliente) 
  - [7.2.4 Dar feedback nas avaliações do amigo](#71-acessar-funções-restritas)
  - [7.2.5 Retirar "joinha"](#72-efetuar-registro)
  - [7.2.6 Acessar próprio perfil](#73-efetuar-seu-próprio-pedido)
  - [7.2.7 Listar avaliações realizadas pelo membro logado](#74-efetuar-pedido-para-o-cliente)
  - [7.2.8 Listar amigos e recomendações recebidas](#73-efetuar-seu-próprio-pedido)
  - [7.2.9 Reunir avaliações do Item](#74-efetuar-pedido-para-o-cliente) 
  - [7.3.1 Ordenar joinhas de cada avaliação](#71-acessar-funções-restritas)
  - [7.3.2 Consultar Relatório](#72-efetuar-registro)
  - [7.3.3 Consultar Gráfico](#73-efetuar-seu-próprio-pedido)
  - [7.3.4 Consultar média de membros mais conectados](#74-efetuar-pedido-para-o-cliente)
  - [7.3.5 Consultar média de membros](#74-efetuar-pedido-para-o-cliente)
- [8. Diagrama de Sequência](#8-Diagrama-de-Sequência)
- [9. Diagrama de domínio](#9-Diagrama-de-domínio)
- [10. Diagrama de Classes](#10-Diagrama-de-Classes)
- [11. Wireframes](#11-Wireframes)


# 1. Introdução

Este documento é responsável pela especificação de um Sistema que gera recomendações de Livros, Séries e Filmes para seus usuários. O Cortinas busca a interatividade entre seus membros, tendo em vista que este, atua quase como uma rede social, oferecendo uma plataforma com gerenciamento de amigos, avaliação de filmes, series e livros assim como seu cadastro, recomendações, atribuindo avaliações e outras funcionalidades a serem desenvolvidas, para assim chegar em seu maior objetivo, a interação entre os Membros. Tendo em vista o cenário atual da pandemia, os serviços de streaming acabam se tornando cada vez mais uma realidade no dia a dia das pessoas, sendo assim, o Cortinas busca andar lado a lado com estes serviços proporcionando uma maior experiência aos seus Membros.

Este também, descreve os requisitos não-funcionais, modela os requisitos funcionais com casos de uso, modela os conceitos do domínio do problema e sugere protótipos relacionados aos requisitos seguindo conceitos de interface (UI/UX) e prospecção aos Membros.

# 2. Informações sobre a empresa

A Empresa Cortinas analisa o mercado digital, tendências e mudanças, e atua drasticamente no desenvolvimento de ambientes responsivos e inovadores que gerem interatividade entre seus Membros.
Atua também, no âmbito socioambiental, tendo em vista que gera, com base em sua receita, investimentos na conscientização digital e no mercado de recursos e combustíveis renováveis.


# 3. Escopo do projeto

  Sistema Web que oferece á seus Usuários uma plataforma para adição, compartilhamento e interação entre os Membros, e/ou consumidores de Séries, Filmes e Livros.
  O projeto aborda de forma inovadora, como uma rede social, as contribuições e participações entre nossos Membros, isto é, abordaremos o Escopo prático, assim como Desenvolvimento, Especificação e Revisão. 

# 4. Interessados

  Usuário/Membro: Qualquer pessoa da empresa, ou fora dela, pode se registrar nesta rede social. <br>
  Administrador de Conteúdo: Aquele que será responsável por validar itens adicionados pelos Usuários. <br>
  Administrador de Algoritmo: Ficará responsável por administrar o algoritmo que oferecerá recomendações a um determinado membro. <br>
  Gerente de Serviço: Atualiza informações dos itens e dados cadastrais dos usuários. <br>
  
# 5. Requisitos Funcionais
|RF |  Descrição  |
| :---: | ------------------- |
|  1 |  O sistema deve permitir o login de um usuário, fornecendo nome completo, username, senha, data de nascimento, cidade e estado. |
|  2 |  O sistema deverá utilizar um algoritmo colaborativo para oferecer as recomendações a um determinado membro. Isto quer dizer que o sistema deverá identificar membros que têm um perfil semelhante com base nas avaliações já realizadas e oferecer recomendações com base no que estes membros avaliaram bem. |
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
<img src = "Diagramas/Casos de Uso/Cenario01 -Cadastrar Novo Membro.png">
 </p>

## 7.1. Fazer Registro

| **Objetivo:** | Especificar as etapas que um membro recém-chegado a plataforma deve tomar para efetuar registro e atualizar seus dados. |
| :---: | -------------------  |
| **Atores:** | Membro não registrado |
| **Pré-condições:** | Deverá fornecer seus dados corretamente como: Nome completo, username, senha, data de nascimento, cidade e estado. |
| **Pós-Condições:**  | O sistema mostra o membro já registrado. |
| **Fluxo Principal:** | a: O ator decide efetuar cadastro na plataforma <br> b: Insere os dados requisitados <br> c: O sistema valida os dados inseridos <br> d: O sistema retorna uma mensagem de conclusão de registro. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br> a: O ator decide efetuar cadastro na plataforma <br> b: Insere os dados requisitados <br> c: O sistema verifica algum erro nos dados inseridos <br> d: O sistema encontra o erro <br> e: Retorna ao passo ```b``` do Fluxo Principal para refazer o processo. <br><br> <strong>Fluxo Alternativo B: </strong> <br> a: O ator conclui com sucesso o cadastro e entra no sistema. <br> b: Membro seleciona a opção para acessar seus dados <br> c: Membro seleciona a opção para modificar os dados e insere suas modificações <br> d: O membro verifica as modificações <br> e: Sistema valida os dados e confirma modificações. <br> <br> <strong>Fluxo Alternativo C:</strong> <br> a: O ator conclui com sucesso o cadastro e entra no sistema. <br> b: Membro seleciona a opção para acessar seus dados <br> c: Membro seleciona a opção para modificar os dados e insere suas modificações <br> d: O membro verifica as modificações <br> e: Sistema invalida os dados e retorna para ao passo ```c``` do Fluxo Alternativo C |


<hr>
Cenário 02 - Acessar Conta Cadastrada
<p align = "center">
<img src = "Diagramas/Casos de Uso/Cenario02 - Acessar Conta Cadastrada.png" >
</p>

## 7.1.2 Fazer Login

| **Objetivo:** | Especificar as etapas que um membro recém-chegado a plataforma deve tomar para efetuar registro e atualizar seus dados. |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Deverá fornecer seu nome de usuário e senha pré-definidos no cadastro. |
| **Pós-Condições:**  | O sistema dispõe todas suas funcionalidades ao membro logado. |
| **Fluxo Principal:** | a: O usuário seleciona a operação para efetuar o login.<br> b: O sistema solicita o seu nome de usuário e a sua senha.<br> c: O usuário entra seu username e sua senha.<br>d: O sistema verifica que o username e a senha correspondem às informações de um de seus usuários registrados.<br>e: O sistema inicia uma sessão e apresenta uma mensagem de boas-vindas.|
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br> a: O usuário seleciona a operação para efetuar o login. <br> b: O sistema solicita o seu nome de usuário e a sua senha. <br> c: O usuário entra seu username e sua senha. <br> d: O sistema encontra um erro baseado no username inserido <br> e: Retorna ao passo ```b``` do Fluxo Principal para refazer o processo. <br><br> <strong>Fluxo Alternativo B: </strong> <br> a: O usuário seleciona a operação para efetuar o login. <br> b: O sistema solicita o seu nome de usuário e a sua senha. <br>  c: O usuário entra seu username e sua senha. <br> d: O sistema encontra um erro baseado na senha inserida <br> e: Sistema retorna ao passo ```d``` do Fluxo principal usando o username previamente inserido e verificado e a nova senha.   |



## 7.1.3 Sugere membros para serem amigos

| **Objetivo:** | Sempre que um membro previamente registrado acessar o sistema, este receberá sugestões de 3 membros que poderiam ser seus amigos. |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. Analisar as preferências e identificar aqueles com preferências semelhantes, com base nas avaliações já realizadas. |
| **Pós-Condições:**  | Caso o Usuário envie alguma solicitação de amizade, este deverá enviá-la ao outro membro, e assim, não sugerir mais este perfil ao membro logado. Após mandado ou não a solicitação ele retorna a página principal. |
| **Fluxo Principal:** | a: Sistema analisa avaliações realizadas. <br> b: Sistema retorna 3 membros como sugestões. <br> c: Membro seleciona os perfis desejados caso haja. <br> d: Membro envia solicitações aos perfis selecionados. <br> e: Sistema agrupa solicitações já enviadas|
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Sistema analisa avaliações realizadas. <br> b: Sistema não encontra avaliações. |

<hr> 

Cenário 3 - Avaliar Itens Existentes

<img src="Diagramas/Casos de Uso/Cenario03 - Avaliar itens Existentes.png">

## 7.1.4 Avaliar Filmes, Séries e Livros

| **Objetivo:** | O membro poderá avaliar filmes, séries e livros com comentários e atribuição de nota. |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. Só será feita a avaliação caso o item esteja cadastrado no sistema. |
| **Pós-Condições:**  | Visualizar a avaliação postada. |
| **Fluxo Principal:** | a: Membro seleciona tipo de item. <br> b: Sistema valida item. <br> c: Membro deve necessariamente atribuir uma nota de 0 a 10. <br> d: Sistema valida nota. <br> e: Membro pode adicionar comentário. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Membro seleciona tipo de item. <br> b: Membro seleciona mais de um tipo de item <br> c: Sistema retorna ao passo ```a```. <br><br> <strong>Fluxo Alternativo B: </strong> <br> a: Membro seleciona tipo de item. <br> b: Sistema valida item. <br> c: Membro atribui nota diferente do intervalo de 0 a 10. <br> d: Sistema invalida nota <br> e: Sistema retorna ao passo ```c``` do Fluxo Principal.|

<hr>

Cenário 4 - Cadastrar Novo Item (Série, filmes, livros)

<img src="Diagramas/Casos de Uso/Cenario04 - Cadastrar Novo item.png">

## 7.1.5 Cadastrar Novo Item (Série, filmes, livros)

| **Objetivo:** | O membro poderá cadastrar um novo item no sistema.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. Só será feito o cadastro caso o item não exista no sistema. |
| **Pós-Condições:**  | Visualizar o item cadastrado. |
| **Fluxo Principal:** | a: Membro clica no botão de cadastro de item. <br> b: Membro seleciona tipo de item. <br> c: Sistema valida item. <br> d: Membro coloca informações do item e os envia. <br> e: Administrador de Conteúdo valida informações de cadastro do item. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Membro seleciona tipo de item. <br> b: Membro seleciona mais de um tipo de item. <br> c: Sistema retorna ao passo ```a```. <br><br> <strong>Fluxo Alternativo B: </strong> <br> a: Membro seleciona tipo de item. <br> b: Sistema valida item. <br> c: Membro coloca informações do item. <br> d: Administrador invalida informações <br> e: Sistema retorna ao passo ```d``` do Fluxo Principal.|

<hr>

## 7.1.6 Validar Itens
| **Objetivo:** | O Administrador de Conteúdo validará os itens.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. Só será feito a validação caso seja recebido uma solicitação de cadastro. |
| **Pós-Condições:**  | Visualizar o item validado. |
| **Fluxo Principal:** | a: Administrador de Conteúdo visualiza item. <br> b: Administrador de Conteúdo valida informações de cadastro do item. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Administrador de Conteúdo visualiza item. <br> b: Administrador de Conteúdo invalida informação. <br> c: Sistema retorna ao passo ```a```.|

<hr>

Cenário 5 - Apresentar Recomendações de Itens
<img src="Diagramas/Casos de Uso/Cenario05- Apresentar Recomendações de Itens.png">

## 7.1.7 Apresentar Recomendações de Itens para cada membro

| **Objetivo:** | O Algoritmo Colaborativo apresentará recomendações de itens para um membro.  |
| :---: | -------------------  |
| **Atores:** | Algoritmo Colaborativo |
| **Pré-condições:** | Só será feito a recomendação caso o sistema possua 10 membros cadastrados e esses membros entrarem em pelo menos 10 avaliações. |
| **Pós-Condições:**  | Visualizar recomendações de filmes, séries e livros de cada membro. |
| **Fluxo Principal:** | a: Sistema avalia pré-condições. <br> b: Sistema valida pré-condições. <br> c: Algoritmo Colaborativo identifica itens semelhantes já aprovados. <br> d: Algoritmo Colaborativo apresenta recomendações ao membro. |
| **Fluxo Alternativo:**  |  |

<hr>

## 7.1.8 Identificar Membros com perfil semelhante
| **Objetivo:** | O Algoritmo Colaborativo identifica perfis semelhantes com base nas suas avaliações.  |
| :---: | -------------------  |
| **Atores:** | Algoritmo Colaborativo |
| **Pré-condições:** | Só será feito a recomendação caso o sistema possua 10 membros cadastrados e esses membros entrarem em pelo menos 10 avaliações. |
| **Pós-Condições:**  | Visualizar o perfis semelhantes. |
| **Fluxo Principal:** | a: Algoritmo Colaborativo analisa avaliações dos membros cadastrados. <br> b: Algoritmo Colaborativo identifica possíceis itens semelhantes. <br> c: Algoritmo Colaborativo aprova itens encontrados. |
| **Fluxo Alternativo:**  |  |


<hr>

Cenário 6 - Acessar e adicionar perfis
<img src="Diagramas/Casos de Uso/Cenario06 - Acessar e adicionar perfis .png">

## 7.1.9 Pesquisar outros membros
| **Objetivo:** | O Membro poderá pesquisar outros membros.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. |
| **Pós-Condições:**  | Visualizar membros pesquisados. |
| **Fluxo Principal:** | a: Membro vai na barra de pesquisa. <br> b: Membro procura perfil pelo nome. <br> c: Sistema filtra opções. <br> d: Sistema retorna opções com amigos em comum para usuário. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Membro vai na barra de pesquisa. <br> b: Membro procura perfil pelo nome. <br> c: Sistema filtra opções. <br> d: Sistema não encontra perfil correspondente a pesquisa. <br> e: Sistema retorna ao passo ```b```.|

<hr>

## 7.2.1 Propor relacionamento de amizade
| **Objetivo:** | O Membro poderá propor amizade a outro membro.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. |
| **Pós-Condições:**  | Visualizar proposta de amizade enviada. |
| **Fluxo Principal:** | a: Membro recebe opções. <br> b: Membro envia solicitação de amizade ao perfil desejado. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Membro recebe opções. <br> b: Membro não recebe opção desejada. <br> e: Membro retorna ao passo ```b``` do CSU 7.9.|

<hr>

## 7.2.2 Verificar pendências de amizade
| **Objetivo:** | O Membro poderá verificar suas pendências de relacionamento.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. |
| **Pós-Condições:**  | Visualizar pendências de relacionamento. |
| **Fluxo Principal:** | a: Membro requisita lista de pendências. <br> b: Sistema retorna pendências para o Membro. <br> c: Membro responde a lista de pendências. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br> a: Membro requisita lista de pendências. <br> b: Sistema retorna 0 pendências para o Membro. <br> c: Sistema retorna ao passo ```a```.|

<hr>

Cenário 7 - Avaliar e mostrar membro amigo
<img src="Diagramas/Casos de Uso/Cenario07 - Avaliar e mostrar membro amigo.png">

## 7.2.3 Listar avaliações realizadas pelo membro amigo
| **Objetivo:** | O Administrador de Conteúdo listará as avaliações de um membro.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. Só será feito a listagem caso haja avaliação de outros membros. |
| **Pós-Condições:**  | Visualizar lista de avaliações. |
| **Fluxo Principal:** | a: Administrador de Conteúdo acessa perfil do membro. <br> b: Administrador de Conteúdo visualiza avaliações feitas. <br> c: Administrador de Conteúdo valida avaliações. <br> d: Administrador de Conteúdo lista avaliações. |
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br>  a: Administrador de Conteúdo acessa perfil do membro. <br> b: Administrador de Conteúdo visualiza avaliações feitas. <br> c: Administrador de Conteúdo invalida avaliações. <br> d: Sistema retorna ao passo ```b```.|

<hr>

## 7.2.4 Dar feedback nas avaliações do amigo
| **Objetivo:** | O Membro poderá dar um feedback(Comentário e/ou "joinha") nas avaliações de um amigo.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. Só poderá ser feito o feedback caso o o Membro possua amizade com quem ele está avaliando. |
| **Pós-Condições:**  | Visualizar feedback na avaliação de um amigo . |
| **Fluxo Principal:** | a: Membro acessa página de amigo <br> b: Membro escolhe avaliação do amigo. <br> c: Membro dá feedback. <br> d: Sistema valida feedback.  <br> e: Sistema "posta" feedback. <br> f: Membro pode dar "joinha".|
| **Fluxo Alternativo:**  |  <strong>Fluxo Alternativo A:</strong> <br>  a: Membro acessa página de amigo <br> b: Membro escolhe avaliações do amigo. <br> c: Sistema invalida mais de uma escolha. <br> d: Sistema retorna ao passo ```b``` do Fluxo Principal. <br> <br> <strong>Fluxo Alternativo A:</strong> <br> a: Membro acessa página de amigo <br> b: Membro escolhe avaliação do amigo. <br> c: Membro dá feedback. <br> d: Sistema invalida feedback. <br> e: Sistema retorna ao passo ```c```.|

<hr>

## 7.2.5 Retirar "joinha"
| **Objetivo:** | O Membro poderá retirar um "joinha" dado.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. Só poderá ser retirado o "joinha" caso o Membro já tenha dado um. |
| **Pós-Condições:**  | Visualizar "joinha" retirado . |
| **Fluxo Principal:** | a: Membro acessa feedback dado ao amigo <br> b: Membro clica no botão de retirar "joinha". <br> c: Sistema retira "joinha". |
| **Fluxo Alternativo:**  |  |

<hr>

Cenário 8 - Acessar página pessoal(perfil)
<img src="Diagramas/Casos de Uso/Cenario08 - Acessar página pessoal (perfil).png">

## 7.2.6 Acessar próprio perfil
| **Objetivo:** | Membro acessa seu perfil.  |
| :---: | -------------------  |
| **Atores:** | Membro |
| **Pré-condições:** | Estar previamente logado. |
| **Pós-Condições:**  | Visualizar perfil. |
| **Fluxo Principal:** | a: Membro clica na sua imagem de perfil localizada no canto superior direito. <br> b: Membro visualiza opções. <br> c: Membro acessa a opção "Ver meu perfil". <br> d: Sistema retorna perfil para o Membro. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Membro clica no sua imagem de perfil localizada no canto superior direito. <br> b: Membro visualiza opções. <br> c: Membro acessa a opção errada. <br> d: Sistema retorna ao passo ```b```. |

<hr>

## 7.2.7 Listar avaliações realizadas pelo membro logado
| **Objetivo:** | Administrador de Conteúdo fará listagem de avaliações realizadas pelo membro.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar perfil. |
| **Fluxo Principal:** | a: Membro solicita ver seu próprio perfil. <br> b: Administrador de Conteúdo automaticamente faz a listagem de avaliações. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Membro solicita ver seu próprio perfil. <br> b: Administrador de Conteúdo retorna mensagem de 0 avaliações. |

<hr>


## 7.2.8 Listar amigos e recomendações recebidas
| **Objetivo:** | Administrador de Conteúdo fará listagem de amigos e recomendações recebidas.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar perfil. |
| **Fluxo Principal:** | a: Administrador de Conteúdo verifica amigos do Membro. <br> b: Administrador de Conteúdo faz listagem de amigos do Membro. <br> c: Administrador de Conteúdo verifica recomendações enviadas ao Membro.  <br> d: Administrador de Conteúdo automaticamente faz a listagem de recomendações recebidas. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Administrador de Conteúdo verifica amigos do Membro. <br> b: Administrador de Conteúdo não encontra amigos. <br> c: Administrador de Conteúdo verifica recomendações enviadas ao Membro.  <br> d: Administrador de Conteúdo automaticamente faz a listagem de recomendações recebidas. <br> <br> <strong>Fluxo Alternativo B:</strong> <br> a: Administrador de Conteúdo verifica amigos do Membro. <br> b: Administrador de Conteúdo faz listagem de amigos do Membro. <br> c: Administrador de Conteúdo verifica recomendações enviadas ao Membro. <br> d: Administrador de Conteúdo não encontra recomendações recebidas. <br> <br> <strong>Fluxo Alternativo B:</strong> <br> a: Administrador de Conteúdo verifica amigos do Membro. <br> b: Administrador de Conteúdo não encontra amigos. <br> c: Administrador de Conteúdo verifica recomendações enviadas ao Membro. <br> d: Administrador de Conteúdo não encontra recomendações recebidas. |

<hr>

Cenário 9 - Acessar página do Item
<img src="Diagramas/Casos de Uso/Cenario09 - Acessar página do Item.png">

## 7.2.9 Reunir avaliações do Item
| **Objetivo:** | O Administrador de Conteúdo reunirá as avaliações de um Item.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. Só será reunido caso haja mais de uma avaliação. |
| **Pós-Condições:**  | Visualizar avaliações reunidas. |
| **Fluxo Principal:** | a: Administrador de Conteúdo visualiza item. <br> b: Administrador de Conteúdo seleciona item. <br> c: Administrador de Conteúdo visualiza avaliações. <br> e: Administrador de Conteúdo reúne avaliações.  |
| **Fluxo Alternativo:**  | |

<hr>

## 7.3.1 Ordenar joinhas de cada avaliação
| **Objetivo:** | O Administrador de Conteúdo ordenará a quantidade de "joinhas" de uma avaliação.  |
| :---: | -------------------  |
| **Atores:** | Administrador de Conteúdo |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. Só será ordenado caso haja mais de um "joinha". |
| **Pós-Condições:**  | Visualizar quantidade de "joinhas". |
| **Fluxo Principal:** | a: Administrador de Conteúdo visualiza item. <br> b: Administrador de Conteúdo seleciona item. <br> c: Administrador de Conteúdo acessa avaliação do item. <br> e: Administrador de Conteúdo ordena "joinhas".  |
| **Fluxo Alternativo:**  | |

<hr>


Cenário 10 - Consultar dados dos usuários
<img src="Diagramas/Casos de Uso/Cenario10- Consultar dados dos usuários.png">

## 7.3.2 Consultar Relatório
| **Objetivo:** | O Gerente de Serviço consultará um relatório referente aos membros cadastrados a plataforma.  |
| :---: | -------------------  |
| **Atores:** | Gerente de Serviço |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar relatório. |
| **Fluxo Principal:** | a: Gerente de Serviço requisita relatório. <br> b: Sistema retorna relatório. <br> c: Gerente de Serviço acessa relatório. <br> d: Gerente de Serviço visualiza relatório. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Gerente de Serviço requisita relatório. <br> b: Sistema indisponível. <br> c: Sistema retorna ao passo ```a```.|

<hr>


## 7.3.3 Consultar Gráfico
| **Objetivo:** | O Gerente de Serviço consultará um gráfico da relação entre amigos e o estado onde moram.  |
| :---: | -------------------  |
| **Atores:** | Gerente de Serviço |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar gráfico. |
| **Fluxo Principal:** | a: Gerente de Serviço requisita gráfico. <br> b: Sistema retorna gráfico. <br> c: Gerente de Serviço acessa gráfico. <br> d: Gerente de Serviço visualiza gráfico. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Gerente de Serviço requisita gráfico. <br> b: Sistema indisponível. <br> c: Sistema retorna ao passo ```a```.|

<hr>

## 7.3.4 Consultar média de membros mais conectados
| **Objetivo:** | O Gerente de Serviço consultará uma média de membros mais conectados.  |
| :---: | -------------------  |
| **Atores:** | Gerente de Serviço |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar média de membros mais conectados. |
| **Fluxo Principal:** | a: Gerente de Serviço requisita média de membros mais conectados. <br> b: Sistema retorna média de membros mais conectados. <br> c: Gerente de Serviço acessa média de membros mais conectados. <br> d: Gerente de Serviço visualiza média de membros mais conectados. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Gerente de Serviço requisita  média de membros mais conectados. <br> b: Sistema indisponível. <br> c: Sistema retorna ao passo ```a```.|

<hr>

## 7.3.5 Consultar média de membros
| **Objetivo:** | O Gerente de Serviço consultará uma média de membros.  |
| :---: | -------------------  |
| **Atores:** | Gerente de Serviço |
| **Pré-condições:** | Estar previamente logado e ter permissão para tais acessos. |
| **Pós-Condições:**  | Visualizar média de membros. |
| **Fluxo Principal:** | a: Gerente de Serviço requisita média de membros. <br> b: Sistema retorna média de membros. <br> c: Gerente de Serviço acessa média de membros. <br> d: Gerente de Serviço visualiza média de membros. |
| **Fluxo Alternativo:**  | <strong>Fluxo Alternativo A:</strong> <br>  a: Gerente de Serviço requisita  média de membros. <br> b: Sistema indisponível. <br> c: Sistema retorna ao passo ```a```.|

<hr>

# 8. Diagrama de Sequência




# 9. Diagrama de domínio






# 10. Diagrama de Classes



# 11. Wireframes
