package br.com.stelo.vendedor.cadastro.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.models.Categoria;
import br.com.stelo.vendedor.cadastro.models.SubCategoria;
import br.com.stelo.vendedor.cadastro.models.constraints.DataAlteracao;
import br.com.stelo.vendedor.cadastro.models.Loja;
import br.com.stelo.vendedor.cadastro.ports.CategoriaRepository;
import br.com.stelo.vendedor.cadastro.ports.CategoriaService;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CategoriaServiceAdapter implements CategoriaService {

	private static final Logger log = LoggerFactory.getLogger(CategoriaServiceAdapter.class);

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public List<Categoria> getAllCategorias() {
		log.info("### CategoriaServiceAdapter.getAll");
		return categoriaRepository.getAllCategorias();
	}
	
	@Override
	public List<SubCategoria> getSubCategoriasByCategoria(long idCategoria) {
		log.info("### CategoriaServiceAdapter.getAllByCategoria");
		return categoriaRepository.getSubcategoriasByCategoria(idCategoria);
	}

	@Override
	public boolean updateCategoria(Loja loja, String userName) {
		log.info("### CategoriaServiceAdapter.updateCategoria");
        return categoriaRepository.updateCategoria(loja, userName);
	}

	@Override
	public boolean checkUltimaAlteracao(long idStelo) {
		log.info("### CategoriaServiceAdapter.checkUltimaAlteracao");
        Date ultimaAlteracao = categoriaRepository.getUltimaAlteracao(idStelo);
        boolean isvalid = DataAlteracao.check(ultimaAlteracao);
		return isvalid;
	}
}
