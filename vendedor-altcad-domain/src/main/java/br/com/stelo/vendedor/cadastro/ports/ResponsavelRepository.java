package br.com.stelo.vendedor.cadastro.ports;

import java.util.Date;

import br.com.stelo.vendedor.cadastro.models.Responsavel;

public interface ResponsavelRepository {
    boolean updateResponsavel(Responsavel responsavel, String userName);

	Date getUltimaAlteracao(long idStelo);
}
