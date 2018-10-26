package br.com.stelo.vendedor.cadastro.repositoryadapters.db;

import java.util.List;

import br.com.stelo.vendedor.cadastro.models.Loja;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.CategoriaEntity;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.SubCategoriaEntity;

public interface ICategoriaDAO {

	List<CategoriaEntity> getAllCategorias();
	List<SubCategoriaEntity> getSubcategoriasByCategoria(long idCategoria);
	boolean updateCategoria(Loja loja, String usuarioLogado);	

}
