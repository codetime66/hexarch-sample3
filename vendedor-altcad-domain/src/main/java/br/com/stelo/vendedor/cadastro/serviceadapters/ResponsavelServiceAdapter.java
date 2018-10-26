package br.com.stelo.vendedor.cadastro.serviceadapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.stelo.vendedor.cadastro.models.Responsavel;
import br.com.stelo.vendedor.cadastro.models.constraints.DataAlteracao;
import br.com.stelo.vendedor.cadastro.ports.ResponsavelRepository;
import br.com.stelo.vendedor.cadastro.ports.ResponsavelService;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ResponsavelServiceAdapter implements ResponsavelService {

	private static final Logger log = LoggerFactory.getLogger(ResponsavelServiceAdapter.class);

	@Autowired
	private ResponsavelRepository responsavelRepository;

	@Override
	public boolean updateResponsavel(Responsavel responsavel, String userName) {
		log.info("### ResponsavelServiceAdapter.updateResponsavel");
        return responsavelRepository.updateResponsavel(responsavel, userName);
	}

	@Override
	public boolean checkUltimaAlteracao(long idStelo) {
		log.info("### ResponsavelServiceAdapter.checkUltimaAlteracao");
        Date ultimaAlteracao = responsavelRepository.getUltimaAlteracao(idStelo);
        boolean isvalid = DataAlteracao.check(ultimaAlteracao);
		return isvalid;
	}
}
