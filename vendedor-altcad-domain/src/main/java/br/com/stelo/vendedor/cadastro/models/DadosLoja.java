package br.com.stelo.vendedor.cadastro.models;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DadosLoja {
    private BigDecimal idStelo;
    private Date dataAlteracao;
}
