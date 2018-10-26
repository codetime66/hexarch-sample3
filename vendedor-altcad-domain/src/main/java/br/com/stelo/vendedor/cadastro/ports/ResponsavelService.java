package br.com.stelo.vendedor.cadastro.ports;

import br.com.stelo.vendedor.cadastro.models.Responsavel;

public interface ResponsavelService {
   boolean updateResponsavel(Responsavel responsavel, String userName);

   boolean checkUltimaAlteracao(long idStelo);
}
