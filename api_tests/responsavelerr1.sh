#!/bin/bash
curl -X PUT -H "Content-Type: application/json" -d '{
  "idStelo": 1,
  "name": "carlos",
  "cpf": "94393915704",
  "birthDate": "01/09/1966",
  "email": "carlosandrefernandes@gmail.com",
  "celular": "",
  "telefone": ""
}' "http://localhost:7125/vendedor-cadastro/responsavel"
