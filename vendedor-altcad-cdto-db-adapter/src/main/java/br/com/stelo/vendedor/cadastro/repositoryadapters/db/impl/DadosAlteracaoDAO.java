package br.com.stelo.vendedor.cadastro.repositoryadapters.db.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stelo.vendedor.cadastro.models.DadosLoja;
import br.com.stelo.vendedor.cadastro.models.DadosPIN;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavel;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavelFone;
import br.com.stelo.vendedor.cadastro.models.EnderecoLoja;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;

@Transactional
@Repository
public class DadosAlteracaoDAO implements IDadosAlteracaoDAO {

	private static final Logger log = LoggerFactory.getLogger(DadosAlteracaoDAO.class);

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public EnderecoLoja getEnderecoLoja(long idStelo) {
		StringBuilder hql = new StringBuilder();
		log.info("### DadosAlteracaoDAO.getEnderecoLoja");
		hql.append("select ");
		hql.append("   ender.ID_ENDER, ");
		hql.append("   ender.LOGDR, ");
		hql.append("   ender.CEP, ");
		hql.append("   ender.NU_ENDER, ");
		hql.append("   ender.COMPL, ");
		hql.append("   ender.BAIRO, ");
		hql.append("   ender.CIDDE, ");
		hql.append("   ender.EST, ");
		hql.append("   ender.DT_ALT ");
		hql.append(" from ");
		hql.append("   USR_CADU.TB_ENDER ender cross");
		hql.append("   join");
		hql.append("   USR_CADU.TB_PSSOA_RLCTO rel");
		hql.append(" where");
		hql.append("   ender.ID_RLCTO=rel.ID_RLCTO");
		hql.append("   and rel.ID_STELO=:ID_STELO");		

		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("ID_STELO", idStelo);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();

		if (result != null && !result.isEmpty()) {
			return EnderecoLoja
					.builder()
					.idEndereco((BigDecimal)(result.get(0))[0])
					.dataAlteracao((Date)(result.get(0))[8])
					.build();
		}
		return null;
	}
	
	@Override
	public DadosResponsavel getDadosResponsavel(long idStelo) {
		StringBuilder hql = new StringBuilder();
		log.info("### DadosAlteracaoDAO.getDadosResponsavel");

		hql.append("select");
		hql.append("   pf.id_stelo, ");
		hql.append("   pf.NM_COPLT, ");
		hql.append("   pf.CPF, ");
		hql.append("   pf.DT_NASC, ");
		hql.append("   emails.id_email, ");
		hql.append("   emails.EMAIL, ");
		hql.append("   pf.DT_ALT ");
		hql.append(" from ");
		hql.append("   USR_CADU.TB_PSSOA_RLCTO rel ");
		hql.append("   left outer join USR_CADU.TB_EC ec on rel.ID_EC=ec.ID_STELO ");
		hql.append("   left outer join USR_CADU.TB_EMAIL emails on rel.ID_RLCTO=emails.ID_RLCTO, ");
		hql.append("   USR_CADU.TB_PSSOA pessoa, ");
		hql.append("   USR_CADU.TB_PSSOA_FIS pf ");
		hql.append(" where ");
		hql.append("   rel.ID_STELO=pessoa.ID_STELO ");
		hql.append("   and pessoa.ID_STELO=pf.ID_STELO ");
		hql.append("   and ( ec.ID_STELO=:ID_STELO or rel.ID_STELO=:ID_STELO ");
		hql.append("   and ( (ec.ID_STELO is null) and rel.ID_TP_RLCTO=1 or rel.ID_TP_RLCTO=10 ) ");
		hql.append("   and rownum=1 )");

		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("ID_STELO", idStelo);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();

		if (result != null && !result.isEmpty()) {
			return DadosResponsavel.builder()
					.idResponsavel((BigDecimal) (result.get(0))[0])
					.idEmail((BigDecimal) (result.get(0))[4])
					.dataAlteracao((Date) (result.get(0))[6])
					.build();
		}
		return null;
	}

	@Override
	public List<DadosResponsavelFone> getDadosResponsavelFone(long idStelo) {
		StringBuilder hql = new StringBuilder();
		log.info("### DadosAlteracaoDAO.getDadosResponsavelFone");

		hql.append("select");
		hql.append("   tel.id_fone, ");
		hql.append("   tel.id_tp_fone ");
		hql.append(" from ");
		hql.append("   USR_CADU.TB_PSSOA_RLCTO rel ");
		hql.append("   left outer join ");
		hql.append("   USR_CADU.TB_FONE tel ");
		hql.append("   on rel.ID_RLCTO=tel.ID_RLCTO ");
		hql.append(" where ");
		hql.append("   rel.ID_STELO=:ID_STELO ");

		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("ID_STELO", idStelo);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();

		if (result != null && !result.isEmpty()) {
			return getFoneList(result);
		}
		return null;
	}
	
	private List<DadosResponsavelFone> getFoneList(List<Object[]> result) {
		List<DadosResponsavelFone> _list = result.stream()
				.map(obj -> DadosResponsavelFone
						.builder()
						.idFone((BigDecimal) (obj)[0])
						.idTpFone((BigDecimal) (obj)[1])
						.build())
				.collect(Collectors.toList());
		return _list;
	}
	
	@Override
	public DadosLoja getDadosLoja(long idStelo) {
		StringBuilder hql = new StringBuilder();
		log.info("### DadosAlteracaoDAO.getEnderecoLoja");
		
		hql.append("select");
		hql.append("  ec.id_stelo,");
		hql.append("  ec.id_categ,");
		hql.append("  ec.id_sub_categ,");
		hql.append("  ec.dt_alt");
		hql.append(" from ");
		hql.append("  USR_CADU.TB_EC ec,");
		hql.append("  USR_ICOR.TB_CATEG categ,");
		hql.append("  USR_ICOR.TB_SUBCATEG subcateg");
		hql.append(" where ");
		hql.append("  ec.id_categ=categ.id_categ");
		hql.append("  and ec.id_sub_categ=subcateg.id_subcateg");  
		hql.append("  and ec.ID_STELO=:ID_STELO");
		
		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("ID_STELO", idStelo);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();

		if (result != null && !result.isEmpty()) {
			return DadosLoja
					.builder()
					.idStelo((BigDecimal)(result.get(0))[0])
					.dataAlteracao((Date)(result.get(0))[3])
					.build();
		}
		return null;
	}

	@Override
	public DadosPIN getDadosEnvioPIN(long idStelo) {
		StringBuilder hql = new StringBuilder();
		log.info("### DadosAlteracaoDAO.getDadosEnvioPIN");
		
		hql.append("select");
		hql.append("   pessoa.ID_STELO,");
		hql.append("   tel.id_fone,");
		hql.append("   email.id_email,");
		hql.append("   tel.dt_alt,");
		hql.append("   email.EMAIL,");
		hql.append("   tel.DDD||tel.NU_FONE,");
		hql.append("   pf.NM_COPLT,");
		hql.append("   rel.ID_TP_RLCTO");
		hql.append(" from ");
		hql.append("   USR_CADU.TB_PSSOA pessoa ");
		hql.append(" left outer join ");
		hql.append("   USR_CADU.TB_PSSOA_FIS pf ");
		hql.append("       on pessoa.ID_STELO=pf.ID_STELO ");
		hql.append(" inner join ");
		hql.append("   USR_CADU.TB_PSSOA_RLCTO rel ");
		hql.append("       on pessoa.ID_STELO=rel.ID_STELO ");
		hql.append(" inner join ");
		hql.append("   USR_CADU.TB_EMAIL email ");
		hql.append("       on rel.ID_RLCTO=email.ID_RLCTO ");
		hql.append(" inner join ");
		hql.append("   USR_CADU.TB_FONE tel ");
		hql.append("       on rel.ID_RLCTO=tel.ID_RLCTO ");
		hql.append(" where ");
		hql.append("   pessoa.ID_STELO=:ID_STELO ");
		hql.append("   and tel.ID_TP_FONE=2 ");
		hql.append("   and rel.ID_TP_RLCTO=10 ");
		hql.append("   and rownum=1 ");		
				
		Query query = entityManager.createNativeQuery(hql.toString());
		query.setParameter("ID_STELO", idStelo);
		@SuppressWarnings("unchecked")
		List<Object[]> result = query.getResultList();

		if (result != null && !result.isEmpty()) {
			return DadosPIN
					.builder()
					.idStelo((BigDecimal)(result.get(0))[0])
					.idFone((BigDecimal)(result.get(0))[1])
					.idEmail((BigDecimal)(result.get(0))[2])
					.dataAlteracao((Date)(result.get(0))[3])
					.build();
		}
		return null;
	}	
}