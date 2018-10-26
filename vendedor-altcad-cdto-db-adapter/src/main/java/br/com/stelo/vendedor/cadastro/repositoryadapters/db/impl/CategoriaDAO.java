package br.com.stelo.vendedor.cadastro.repositoryadapters.db.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.stelo.vendedor.cadastro.models.Loja;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.ICategoriaDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.CategoriaEntity;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.SubCategoriaEntity;

@Transactional
@Repository
public class CategoriaDAO implements ICategoriaDAO {

	private static final Logger log = LoggerFactory.getLogger(CategoriaDAO.class);

	@PersistenceContext	
	private EntityManager entityManager;

	@Override
	public List<CategoriaEntity> getAllCategorias() {
		String hql = "FROM "+CategoriaEntity.class.getName()+" as cat ";
		@SuppressWarnings("unchecked")
		List<CategoriaEntity> categorias = entityManager.createQuery(hql).getResultList();
		return categorias;
	}
	
	@Override
	public List<SubCategoriaEntity> getSubcategoriasByCategoria(long idCategoria) {
		String hql = "FROM "+SubCategoriaEntity.class.getName()+" as subcat WHERE subcat.idCategoria = ? ";
		@SuppressWarnings("unchecked")
		List<SubCategoriaEntity> subcategorias = entityManager.createQuery(hql)
		 .setParameter(1, idCategoria)
		 .getResultList();
		return subcategorias;
	}

	@Override
	public boolean updateCategoria(Loja loja, String userName) {
		StringBuilder hql = new StringBuilder();	
		hql.append("update USR_CADU.TB_EC ");
		hql.append(" set ID_CATEG =:ID_CATEG, ");
		hql.append("     ID_SUB_CATEG =:ID_SUB_CATEG, ");
		hql.append("     USUAR_ALT =:USUAR_ALT, ");
		hql.append("     DT_ALT =:DT_ALT");
		hql.append(" where ");
		hql.append("     ID_STELO =:ID_STELO ");

		Query query = entityManager.createNativeQuery(hql.toString());
        query.setParameter("ID_STELO", loja.getIdStelo());
        query.setParameter("ID_CATEG", loja.getIdCategoria());
        query.setParameter("ID_SUB_CATEG", loja.getIdSubCategoria());
        query.setParameter("USUAR_ALT", userName);
        query.setParameter("DT_ALT", new Date());

        int updl = query.executeUpdate();
        
        log.info("### CategoriaDAO.updateCategoria: "+updl);        
        return updl>0;		
	}

}

