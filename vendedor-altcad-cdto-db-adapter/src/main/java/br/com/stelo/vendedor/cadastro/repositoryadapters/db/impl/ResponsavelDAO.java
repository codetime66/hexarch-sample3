package br.com.stelo.vendedor.cadastro.repositoryadapters.db.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stelo.vendedor.cadastro.models.Responsavel;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavel;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IResponsavelDAO;

@Transactional
@Repository
public class ResponsavelDAO implements IResponsavelDAO {

	private static final Logger log = LoggerFactory.getLogger(ResponsavelDAO.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private IDadosAlteracaoDAO dadosAlteracaoDAO;
	
	@Override
	public boolean updateResponsavel(Responsavel responsavel, String userName) {
		
		DadosResponsavel dadosResponsavel = dadosAlteracaoDAO.getDadosResponsavel(responsavel.getIdStelo());
		log.info((dadosResponsavel!=null) ? dadosResponsavel.toString() : "null");
		
		try {
			updatePF(dadosResponsavel, responsavel, userName);
			updateEmail(dadosResponsavel, responsavel, userName);
		} catch (ParseException e) {
			log.error("### ResponsavelDAO.updateResponsavel: "+e.getMessage());
		}
		
		log.info("### ResponsavelDAO.updateResponsavel: ");
		return true;
	}

	private boolean updatePF(DadosResponsavel dadosResponsavel, Responsavel responsavel, String userName) throws ParseException {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_PSSOA_FIS ");
		hql.append(" set NM_COPLT =:NM_COPLT, ");
		hql.append("     CPF =:CPF, ");
		hql.append("     DT_NASC =:DT_NASC, ");
		hql.append("     USUAR_ALT =:USUAR_ALT, ");
		hql.append("     DT_ALT =:DT_ALT");
		hql.append(" where ");
		hql.append("     ID_STELO =:ID_STELO ");

		Query query = entityManager.createNativeQuery(hql.toString());
        query.setParameter("ID_STELO", dadosResponsavel.getIdResponsavel());
        query.setParameter("NM_COPLT", responsavel.getName());
        query.setParameter("CPF", responsavel.getCpf());
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date bd = sdf.parse(responsavel.getBirthDate());
        
        query.setParameter("DT_NASC", bd);
        query.setParameter("USUAR_ALT", userName);
        query.setParameter("DT_ALT", new Date());

        int updl = query.executeUpdate();
        
        log.info("### ResponsavelDAO.updatePF: "+updl);        
        return updl>0;		
	}
	
	private boolean updateEmail(DadosResponsavel dadosResponsavel, Responsavel responsavel, String userName) {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_EMAIL ");
		hql.append(" set EMAIL =:EMAIL, ");
		hql.append("     USUAR_ALT =:USUAR_ALT, ");
		hql.append("     DT_ALT =:DT_ALT");
		hql.append(" where ");
		hql.append("     ID_EMAIL =:ID_EMAIL ");

		Query query = entityManager.createNativeQuery(hql.toString());
        query.setParameter("ID_EMAIL", dadosResponsavel.getIdEmail());
        query.setParameter("EMAIL", responsavel.getEmail());
        query.setParameter("USUAR_ALT", userName);
        query.setParameter("DT_ALT", new Date());

        int updl = query.executeUpdate();
        
        log.info("### ResponsavelDAO.updateEmail: "+updl);        
        return updl>0;		
	}	

}
