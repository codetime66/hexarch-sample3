package br.com.stelo.vendedor.cadastro.ports;

import br.com.stelo.vendedor.cadastro.models.Endereco;

public interface EnderecoService {
   boolean updateEndereco(Endereco endereco, String userName);

   boolean checkUltimaAlteracao(long idStelo);
}
