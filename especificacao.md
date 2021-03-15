---
title: "Especificação do Sistema Aplicativo para Recomendação de Filmes, Séries e Livros"
author: "Prática Profissional em ADS"
---


**Índice**

- [1. Introdução](#1-introdução)
- [2. Informações sobre a empresa](#2-informações-sobre-a-empresa)
- [3. Escopo do projeto](#3-escopo-do-projeto)
- [4. Interessados](#4-interessados)
- [5. Objetivos funcionais](#5-objetivos-funcionais)
- [6. Objetivos não-funcionais](#6-objetivos-não-funcionais)
- [7. COTS (Commercial Off-The-Shelf)](#7-cots-commercial-off-the-shelf)
- [8. Casos de uso](#8-casos-de-uso)
  - [8.1. Acessar funções restritas](#81-acessar-funções-restritas)
  - [8.2. Efetuar registro](#82-efetuar-registro)
  - [8.3. Efetuar seu próprio pedido](#83-efetuar-seu-próprio-pedido)
  - [8.4. Efetuar pedido para o cliente](#84-efetuar-pedido-para-o-cliente)
- [9. Wireframes](#9-wireframes)
- [10. Diagrama de classes de domínio](#10-diagrama-de-classes-de-domínio)


# 1. Introdução

Este documento é responsável pela especificação de um Sistema que gera recomendações de Livros, Series e Filmes para seus usuarios. O Cortinas busca a interatividade entre seus colaboradores, tendo em vista que este,  atua quase como uma rede social, oferencendo uma plataforma com gererenciamento de amigos, avaliação de filmes, series e livros assim como seu cadastro, recomendações, e outras funcionalidades a serem desenvolvidas.

Este tambem, descreve os requisitos não-funcionais, modela os requisitos funcionais com casos de uso e modela os conceitos do domínio do problema.

# 2. Informações sobre a empresa

A Empresa *   * analisa o mercado digital, tendências e mudanças, e atua drasticamente no desenvolvimento de ambientes responsivos e inovadores que gerem interatividade entre seus colaboradores.
Atua tambem, no ambito socio-ambiental, tendo em vista que gera, com base em sua receita, investimentos na conscientização digital e no mercado de recursos e combustiveis renováveis.


# 3. Escopo do projeto



# 4. Interessados




# 5. Objetivos funcionais (Requisitos Funcionais [RF])
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
|  22 |  O sistema deverá permitir que o gerente do serviço consulte: 
a.	O número médio de amigos dos membros da rede social. b.	Uma lista com os 10 membros mais conectados (com o maior número de amigos). c.	Um gráfico mostrando a relação entre o número de amigos e o estado onde mora.|





# 6. Objetivos não-funcionais (Requisitos não Funcionais [RNF])
- O sistema só poderá ser acessado pelo navegador do dispositivo móvel ou pelo computador.
- O sistema deve ser responsivo e leve, para evitar demora no carregamento. 
- O sistema deve usar Base de Dados (Relacional ou NoSQL). 
- O sistema deve ser implantado em um provedor de serviços (AWS, Azure, Google Cloud etc). 
- O sistema deve ter um tempo de recarga de página não deve ser superior a 5 segundos. 
- O sistema deverá atender o padrão 99.99% em regime 24/7. 
- O sistema deverá apresentar indicativos de como seus dados estarão assegurados contra as invasões ao sistema. 


|RNF |  Descrição  |
| :---: | ------------------- |
|  1 |  O sistema só poderá ser acessado pelo navegador do dispositivo móvel ou pelo computador. |
|  2 |  O sistema deve ser responsivo e leve, para evitar demora no carregamento. |
|  3 |  O sistema deve usar Base de Dados (Relacional ou NoSQL). |
|  4 |  O sistema deve ser implantado em um provedor de serviços (AWS, Azure, Google Cloud etc). |
|  5 |  O sistema deve ter um tempo de recarga de página não deve ser superior a 5 segundos. |
|  6 |  O sistema deverá atender o padrão 99.99% em regime 24/7. |
|  7 |  O sistema deverá apresentar indicativos de como seus dados estarão assegurados contra as invasões ao sistema. |


# 7. COTS (Commercial Off-The-Shelf)




# 8. Casos de uso



## 8.1. Acessar funções restritas






## 8.2. Efetuar registro



## 8.3. Efetuar seu próprio pedido



## 8.4. Efetuar pedido para o cliente




# 9. Wireframes




# 10. Diagrama de classes de domínio
