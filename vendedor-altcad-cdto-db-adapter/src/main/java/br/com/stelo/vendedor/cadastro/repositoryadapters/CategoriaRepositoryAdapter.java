package br.com.stelo.vendedor.cadastro.repositoryadapters;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.repositoryadapters.db.ICategoriaDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.IDadosAlteracaoDAO;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.CategoriaEntity;
import br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity.SubCategoriaEntity;
import br.com.stelo.vendedor.cadastro.models.Categoria;
import br.com.stelo.vendedor.cadastro.models.SubCategoria;
import br.com.stelo.vendedor.cadastro.models.Loja;
import br.com.stelo.vendedor.cadastro.models.DadosLoja;
import br.com.stelo.vendedor.cadastro.ports.CategoriaRepository;

@Service
public class CategoriaRepositoryAdapter implements CategoriaRepository {

	@Autowired
	private ICategoriaDAO categoriaDAO;

	@Autowired
	private IDadosAlteracaoDAO dadosAlteracaoDAO;
	
	@Override
	public List<Categoria> getAllCategorias() {
		List<Categoria> categorias = new ArrayList<>();

		List<CategoriaEntity> entities = categoriaDAO.getAllCategorias();
		if (Optional.of(entities).isPresent()) {
			entities.forEach(cat -> {
				Categoria categoria = new Categoria();
				BeanUtils.copyProperties(cat, categoria);
				categorias.add(categoria);
			});
		}
		return categorias;
	}

	@Override
	public List<SubCategoria> getSubcategoriasByCategoria(long idCategoria) {
		List<SubCategoria> subcategorias = new ArrayList<>();

		List<SubCategoriaEntity> entities = categoriaDAO.getSubcategoriasByCategoria(idCategoria);
		if (Optional.of(entities).isPresent()) {
			entities.forEach(subcat -> {
				SubCategoria subcategoria = new SubCategoria();
				BeanUtils.copyProperties(subcat, subcategoria);
				subcategorias.add(subcategoria);
			});
		}
		return subcategorias;
	}

    @Override
	public boolean updateCategoria(Loja loja, String userName) {
		return categoriaDAO.updateCategoria(loja, userName);
	}

    @Override
    public Date getUltimaAlteracao(long idStelo) {
    	DadosLoja dadosLoja =  dadosAlteracaoDAO.getDadosLoja(idStelo);
    	return dadosLoja.getDataAlteracao();
    }
}
