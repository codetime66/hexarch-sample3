package br.com.stelo.vendedor.cadastro.ports;

import java.util.Date;

import br.com.stelo.vendedor.cadastro.models.Endereco;

public interface EnderecoRepository {
    boolean updateEndereco(Endereco endereco, String userName);

	Date getUltimaAlteracao(long idStelo);
}
