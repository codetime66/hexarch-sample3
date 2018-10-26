package br.com.stelo.vendedor.cadastro.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.models.Endereco;
import br.com.stelo.vendedor.cadastro.models.constraints.DataAlteracao;
import br.com.stelo.vendedor.cadastro.ports.EnderecoRepository;
import br.com.stelo.vendedor.cadastro.ports.EnderecoService;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class EnderecoServiceAdapter implements EnderecoService {

	private static final Logger log = LoggerFactory.getLogger(EnderecoServiceAdapter.class);

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Override
	public boolean updateEndereco(Endereco endereco, String userName) {
		log.info("### EnderecoServiceAdapter.updateEndereco");
        return enderecoRepository.updateEndereco(endereco, userName);
	}

	@Override
	public boolean checkUltimaAlteracao(long idStelo) {
		log.info("### EnderecoServiceAdapter.checkUltimaAlteracao");
        Date ultimaAlteracao = enderecoRepository.getUltimaAlteracao(idStelo);
        boolean isvalid = DataAlteracao.check(ultimaAlteracao);
		return isvalid;
	}
}
