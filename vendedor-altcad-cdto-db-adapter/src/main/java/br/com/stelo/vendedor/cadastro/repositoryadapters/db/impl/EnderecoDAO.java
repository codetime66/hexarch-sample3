package br.com.stelo.vendedor.cadastro.repositoryadapters.db.impl;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stelo.vendedor.cadastro.models.Endereco;
import br.com.stelo.vendedor.cadastro.models.EnderecoLoja;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IEnderecoDAO;

@Transactional
@Repository
public class EnderecoDAO implements IEnderecoDAO {

	private static final Logger log = LoggerFactory.getLogger(EnderecoDAO.class);

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Autowired
	private IDadosAlteracaoDAO dadosAlteracaoDAO;

	@Override
	public boolean updateEndereco(Endereco endereco, String userName) {
		EnderecoLoja enderecoLoja = dadosAlteracaoDAO.getEnderecoLoja(endereco.getIdStelo());
		return updateEndereco(enderecoLoja, endereco, userName);
	}
	
	private boolean updateEndereco(EnderecoLoja enderecoLoja, Endereco endereco, String userName) {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_ENDER ");
		hql.append(" set CEP =:CEP, ");
		hql.append("     LOGDR =:LOGDR, ");
		hql.append("     NU_ENDER =:NU_ENDER, ");
		hql.append("     COMPL =:COMPL, ");
		hql.append("     BAIRO =:BAIRO, ");
		hql.append("     CIDDE =:CIDDE, ");
		hql.append("     EST =:EST, ");
		hql.append("     USUAR_ALT =:USUAR_ALT, ");
		hql.append("     DT_ALT =:DT_ALT");
		hql.append(" where ");
		hql.append("     ID_ENDER =:ID_ENDER ");

		Query query = entityManager.createNativeQuery(hql.toString());
        query.setParameter("ID_ENDER", enderecoLoja.getIdEndereco());
        query.setParameter("CEP", endereco.getCep());
        query.setParameter("LOGDR", endereco.getEndereco());
        query.setParameter("NU_ENDER", endereco.getNumero());
        query.setParameter("COMPL", endereco.getComplemento());
        query.setParameter("BAIRO", endereco.getBairro());
        query.setParameter("CIDDE", endereco.getCidade());
        query.setParameter("EST", endereco.getEstado());
        query.setParameter("USUAR_ALT", userName);
        query.setParameter("DT_ALT", new Date());

        int updl = query.executeUpdate();
        
        log.info("### EnderecoDAO.updateEndereco: "+updl);        
        return updl>0;		
	}

}

