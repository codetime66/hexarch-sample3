package br.com.stelo.vendedor.cadastro.ports;

import java.util.Date;
import java.util.List;

import br.com.stelo.vendedor.cadastro.models.Categoria;
import br.com.stelo.vendedor.cadastro.models.SubCategoria;
import br.com.stelo.vendedor.cadastro.models.Loja;

public interface CategoriaRepository {
    List<Categoria> getAllCategorias();
    List<SubCategoria> getSubcategoriasByCategoria(long idCategoria);
    boolean updateCategoria(Loja loja, String userName);
	Date getUltimaAlteracao(long idStelo);
}
