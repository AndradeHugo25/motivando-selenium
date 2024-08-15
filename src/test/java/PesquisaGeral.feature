#language: pt
#encoding: UTF-8

@Globo
Funcionalidade: Pesquisa geral

  Contexto:
    Dado que eu tenha acessado globo.com

  Esquema do Cenário: Pesquisar sobre <valor>
    Quando eu pesquisar por "<valor>"
    Então eu exibo o título da primeira notícia

    Exemplos:
      | valor          |
      | handebol       |
      | rio de janeiro |
      | software       |
