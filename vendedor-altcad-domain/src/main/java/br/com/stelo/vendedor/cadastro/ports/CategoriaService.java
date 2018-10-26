package br.com.stelo.vendedor.cadastro.ports;

import java.util.List;

import br.com.stelo.vendedor.cadastro.models.Categoria;
import br.com.stelo.vendedor.cadastro.models.SubCategoria;
import br.com.stelo.vendedor.cadastro.models.Loja;

public interface CategoriaService {
   List<Categoria> getAllCategorias();
   List<SubCategoria> getSubCategoriasByCategoria(long idCategoria);
   boolean updateCategoria(Loja loja, String userName);
   boolean checkUltimaAlteracao(long idStelo);
}
