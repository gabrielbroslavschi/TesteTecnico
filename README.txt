Para consultar todas as pessoas:
http://localhost:8080/Pessoa/

Para consultar apenas uma pessoa pelo ID:
http://localhost:8080/Pessoa/(ID DA PESSOA QUE DESEJA CONSULTAR)
Exemplo:
http://localhost:8080/Pessoa/1

Para consultar o ENDEREÇO da PESSOA
http://localhost:8080/Pessoa/endereco/(ID DA PESSOA QUE DESEJA CONSULTAR)
Exemplo:
http://localhost:8080/Pessoa/endereco/1

Para consultar o endereço princial da pessoa:
http://localhost:8080/Pessoa/endereco/principal/(ID DA PESSOA QUE DESEJA CONSULTAR)
Exemplo:
http://localhost:8080/Pessoa/endereco/principal/1

Para inserir uma nova pessoa (Recomendo utililizar a ferramenta Postman):
http://localhost:8080/Pessoa/
1° Utilize como POST
2° Coloque no campo "raw":
{
    "id": 1,
    "nome": "Teste",
    "dataNascimento": "20.12.2012"
}


Para realizar a atualização de uma pessoa (Recomendo utilizar a ferramenta Postman):
http://localhost:8080/Pessoa/
1° Utilize como PUT
2° Coloque no campo "raw":
{
    "id": 1,
    "nome": "Realizando a alteração aqui!",
    "dataNascimento": "20.12.2012"
}

Para deletar uma pessoa (Recomendo utilizar a ferramente Postman):
http://localhost:8080/Pessoa/(ID DA PESSOA QUE DESEJA DELETAR)
1° Utilize como DELETE 
Exemplo:
http://localhost:8080/Pessoa/1



+==============+_+==============+_+==============+_+==============+ 

Para consultar todos os endereços:
http://localhost:8080/Endereco/

Para cadastrar um novo endereço (Recomendo utilizar a ferramenta Postman):
http://localhost:8080/Endereco/
1° Utilize como POST
2e Coloque no campo "raw":
{
        "id": 1,
        "numero": 1,
        "cidade": "teste",
        "principal": 1,
        "pessoa": {
            "id": 1,
            "nome": "Teste",
            "dataNascimento": "20.12.2012"
        },
        "logradouro": "Rua do Teste",
        "cep": "123"
}

Para alterar um endereço (Recomendo utilizar a ferramenta Postman):
http://localhost:8080/Endereco/
1° Utilize como PUT
2° Coloque no campo "raw":

{
        "id": 1,
        "numero": 1,
        "cidade": "ALTERAÇÃO FOI REALIZADA AQUI!",
        "principal": 1,
        "pessoa": {
            "id": 1,
            "nome": "Teste",
            "dataNascimento": "20.12.2012"
        },
        "logradouro": "Rua do Teste",
        "cep": "123"
}


Para deletar um endreço (Recomendo utilizar a ferramenta Postman):
http://localhost:8080/Endereco/(ID DO ENDEREÇO QUE DESEJA DELETAR)
1° Utilize como DELETE
Exemplo:
http://localhost:8080/Endereco/1