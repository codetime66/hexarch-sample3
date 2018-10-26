package br.com.stelo.vendedor.cadastro.repositoryadapters;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IEnderecoDAO;
import br.com.stelo.vendedor.cadastro.models.Endereco;
import br.com.stelo.vendedor.cadastro.models.EnderecoLoja;
import br.com.stelo.vendedor.cadastro.ports.EnderecoRepository;

@Service
public class EnderecoRepositoryAdapter implements EnderecoRepository {

	@Autowired
	private IEnderecoDAO enderecoDAO;

	@Autowired
	private IDadosAlteracaoDAO dadosAlteracaoDAO;
	
    @Override
	public boolean updateEndereco(Endereco endereco, String userName) {
		return enderecoDAO.updateEndereco(endereco, userName);
	}

    @Override
    public Date getUltimaAlteracao(long idStelo) {
    	EnderecoLoja endereco =  dadosAlteracaoDAO.getEnderecoLoja(idStelo);
    	return endereco.getDataAlteracao();
    }
}
