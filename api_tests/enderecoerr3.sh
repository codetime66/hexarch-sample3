#!/bin/bash
curl -X PUT -H "Content-Type: application/json" -d '{
  "idStelo": 1,
  "cep": "22270016",
  "endereco": "RUA SEBASTIAO GOMES OLIVEIRA",
  "numero": "451232434332356",
  "complemento": "COMERCIO",
  "bairro": "CENTRO",
  "estado": "MGO",
  "cidade": "Lassance"
}' "http://localhost:7125/vendedor-cadastro/endereco"
