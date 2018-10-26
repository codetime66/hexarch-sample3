package br.com.stelo.vendedor.cadastro.repositoryadapters.db;

import java.util.List;

import br.com.stelo.vendedor.cadastro.models.DadosLoja;
import br.com.stelo.vendedor.cadastro.models.DadosPIN;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavel;
import br.com.stelo.vendedor.cadastro.models.DadosResponsavelFone;
import br.com.stelo.vendedor.cadastro.models.EnderecoLoja;

public interface IDadosAlteracaoDAO {

	EnderecoLoja getEnderecoLoja(long idStelo);

	DadosResponsavel getDadosResponsavel(long idStelo);

	List<DadosResponsavelFone> getDadosResponsavelFone(long idStelo);

	DadosLoja getDadosLoja(long idStelo);

	DadosPIN getDadosEnvioPIN(long idStelo);

}
