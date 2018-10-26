package br.com.stelo.vendedor.cadastro.repositoryadapters;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IResponsavelDAO;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavel;
import br.com.stelo.vendedor.cadastro.models.Responsavel;
import br.com.stelo.vendedor.cadastro.ports.ResponsavelRepository;

@Service
public class ResponsavelRepositoryAdapter implements ResponsavelRepository {

	@Autowired
	private IResponsavelDAO responsavelDAO;

	@Autowired
	private IDadosAlteracaoDAO dadosAlteracaoDAO;

    @Override
	public boolean updateResponsavel(Responsavel responsavel, String userName) {
		return responsavelDAO.updateResponsavel(responsavel, userName);
	}

    @Override
    public Date getUltimaAlteracao(long idStelo) {
    	DadosResponsavel responsavel =  dadosAlteracaoDAO.getDadosResponsavel(idStelo);
    	return responsavel.getDataAlteracao();
    }    
}
