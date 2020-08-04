#language: pt

Funcionalidade: Consulta Cep


Esquema do Cenário:Consulta CEP valido
Dado que o usuário inseri um <cepvalido>
Quando o serviço é consultado
Então é retornado o CEP, logradouro, complemento, bairro, localidade, uf e ibge

Exemplos: 
|cepvalido|
|91751000 |


Esquema do Cenário: Consulta CEP inexistente
Dado que o usuário inseri um <CEP que não exista na base dos Correios>
Quando o serviço é consultado 
Então é retornado um atributo erro

Exemplos: 
|CEP que não exista na base dos Correios|
|							11111111									|


Esquema do Cenário: Consulta CEP com formato inválido 
Dado que o usuário inseri um <CEP com formato inválido>
Quando o serviço é consultado 
Então é retornado uma mensagem de erro

Exemplos: 
|CEP com formato inválido|
|				11111					 |




