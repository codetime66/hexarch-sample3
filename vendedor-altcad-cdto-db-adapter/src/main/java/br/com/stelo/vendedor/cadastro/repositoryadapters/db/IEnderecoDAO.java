package br.com.stelo.vendedor.cadastro.repositoryadapters.db;

import br.com.stelo.vendedor.cadastro.models.Endereco;

public interface IEnderecoDAO {
   boolean updateEndereco(Endereco endereco, String usuarioLogado);	
}
