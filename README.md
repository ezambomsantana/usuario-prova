# usuario-prova

A aplicação possui três rotas:

GET /usuario -> lista todos os usuáris

GET /usuario/{cpf} -> recupera um usuári pelo seu CPF

POST /usuario -> Cria um novo usuário, o body dessa rota é

{
    "nome": "Nome da pessoa",
    "cpf":  "1234"
}