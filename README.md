# usuario-prova

A aplicação possui dois usuários cadastrados já, que são:

e-mail: teste@teste.com
password: teste

e-mail: teste2@teste.com
password: teste2

A rota de login é

A aplicação possui três rotas:

GET /usuario -> lista todos os usuáris

GET /usuario/{cpf} -> recupera um usuári pelo seu CPF

POST /usuario -> Cria um novo usuário, o body dessa rota é

{
    "nome": "Nome da pessoa",
    "cpf":  "1234"
}

A aplicação não aceita a inclusão de pessoas com CPFs repetidos.