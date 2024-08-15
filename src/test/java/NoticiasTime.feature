#language: pt
#encoding: UTF-8

@Globo
Funcionalidade: Notícias do time

  Contexto:
    Dado que eu tenha acessado globo.com
    E que eu tenha acessado o GE

  Cenário: Listar jogos do meu time
    E que eu tenha acessado a home do time
    Quando eu capturar os próximos jogos
    Então eu exibo resultado

