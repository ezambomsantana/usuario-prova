# usuario-prova

A aplicação possui dois usuários cadastrados já, que são:

e-mail: teste@teste.com
password: teste

e-mail: teste2@teste.com
password: teste2

## login

A rota de login pode ser acessada em:

http://184.72.80.215/usuario/login

o body é

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