package br.com.stelo.vendedor.cadastro.repositoryadapters.db;

import br.com.stelo.vendedor.cadastro.models.Responsavel;

public interface IResponsavelDAO {
   boolean updateResponsavel(Responsavel responsavel, String usuarioLogado);
}
