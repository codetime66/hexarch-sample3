package br.com.stelo.vendedor.cadastro.models;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DadosResponsavelFone {
    private BigDecimal idFone;
    private BigDecimal idTpFone;
}
