# usuario-prova

A aplicação possui dois usuários cadastrados já, que são:

e-mail: teste@teste.com
password: teste

e-mail: teste2@teste.com
password: teste2

## login

A rota de login pode ser acessada em:

http://184.72.80.215/usuario/login

o body que deve ser passado nessa rota é:

``` json
{
    "email": "teste@teste.com",
    "password": "teste"
}
```

## validação do token

A rota de validação do token pode ser acessada em:

http://184.72.80.215/usuario/validate

o token deve ser passado no header Authorization.

O retorno dessa rota tem esse formato:

``` json
{
    "nome": "Teste",
    "cpf": "123",
    "email": "teste@teste.com",
    "password": "698dc19d489c4e4db73e28a713eab07b",
    "papel": "ADMIN"
}
```

## outras rotas

Existe uma rota para listar todos os usários, o endereço é:

http://184.72.80.215/usuario

Nela o token também deve ser passado no header Authorization.