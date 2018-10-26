package br.com.stelo.vendedor.cadastro.controllers;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.stelo.vendedor.cadastro.config.UsuarioLogado;
import br.com.stelo.vendedor.cadastro.models.Categoria;
import br.com.stelo.vendedor.cadastro.models.Endereco;
import br.com.stelo.vendedor.cadastro.models.ResponseMessage;
import br.com.stelo.vendedor.cadastro.models.Responsavel;
import br.com.stelo.vendedor.cadastro.models.SubCategoria;
import br.com.stelo.vendedor.cadastro.models.Loja;
import br.com.stelo.vendedor.cadastro.ports.CategoriaService;
import br.com.stelo.vendedor.cadastro.ports.EnderecoService;
import br.com.stelo.vendedor.cadastro.ports.ResponsavelService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("vendedor-cadastro")
@CrossOrigin
public class VendedorRestController {

    @Autowired
    private CategoriaService categoriaService;
        
    @Autowired
    private EnderecoService enderecoService;
    
    @Autowired
    private ResponsavelService responsavelService;
    
    @Autowired
    private UsuarioLogado usuarioLogado;
    
    @CrossOrigin
	@GetMapping("categorias")
	public ResponseEntity<List<Categoria>> getAllCategorias() {
		List<Categoria> list = categoriaService.getAllCategorias();
		return new ResponseEntity<List<Categoria>>(list, HttpStatus.OK);
	}    

    @CrossOrigin
	@GetMapping("categoria/{id}/subcategorias")
	public ResponseEntity<List<SubCategoria>> getSubCategorias(@PathVariable("id") long id) {
		List<SubCategoria> list = categoriaService.getSubCategoriasByCategoria(id);
		return new ResponseEntity<List<SubCategoria>>(list, HttpStatus.OK);
	}    

    @CrossOrigin
	@PutMapping("categoria")
	public ResponseEntity<ResponseMessage> updateCategoria(@RequestBody Loja loja) {
    	String userName = usuarioLogado.getUserName();
    	log.info("### usuarioLogado.getUserName(): " + userName);
        log.info("### Loja: "+loja.toString());
        
        boolean checkDataAlteracao = categoriaService.checkUltimaAlteracao(loja.getIdStelo());
        log.info("### checkDataAlteracao: "+checkDataAlteracao);
        if(!checkDataAlteracao) {
        	return new ResponseEntity<>(ResponseMessage.builder().message("Categoria/Subcategoria já foi alterada").build(), HttpStatus.BAD_REQUEST);        	
        }
        
    	boolean updated = categoriaService.updateCategoria(loja, userName);
		if(updated) {
			return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().message("Categoria/Subcategoria alterada com sucesso").build(), HttpStatus.OK);	
		}
		return new ResponseEntity<ResponseMessage>(ResponseMessage.builder().message("Não foi possível alterar Categoria/Subcategoria").build(), HttpStatus.BAD_REQUEST);
	}

    @CrossOrigin
	@PutMapping("responsavel")
	public ResponseEntity<ResponseMessage> updateResponsavel(@Valid @RequestBody Responsavel responsavel, Errors errors) {
    	if (errors.hasErrors()) {
    		return new ResponseEntity<>(ResponseMessage.builder().message(errorMsg(errors)).build(), HttpStatus.BAD_REQUEST);
    	}
    	String userName = usuarioLogado.getUserName();
    	log.info("### usuarioLogado.getUserName(): " + userName);
        log.info("### responsavel: "+responsavel.toString());
        
        boolean checkDataAlteracao = responsavelService.checkUltimaAlteracao(responsavel.getIdStelo());
        log.info("### checkDataAlteracao: "+checkDataAlteracao);
        if(!checkDataAlteracao) {
        	return new ResponseEntity<>(ResponseMessage.builder().message("Dados do Responsável já foram alterados").build(), HttpStatus.BAD_REQUEST);        	
        }
        
    	boolean updated = responsavelService.updateResponsavel(responsavel, userName);
		if(updated) {
			return new ResponseEntity<>(ResponseMessage.builder().message("Dados do responsável alterados com sucesso").build(), HttpStatus.OK);	
		}
		return new ResponseEntity<>(ResponseMessage.builder().message("Não foi possível alterar os dados do responsável").build(),HttpStatus.BAD_REQUEST);
	}

    @CrossOrigin
	@PutMapping("endereco")
	public ResponseEntity<ResponseMessage> updateEndereco(@Valid @RequestBody Endereco endereco, Errors errors) {
    	if (errors.hasErrors()) {
    		return new ResponseEntity<>(ResponseMessage.builder().message(errorMsg(errors)).build(), HttpStatus.BAD_REQUEST);
    	}
    	String userName = usuarioLogado.getUserName();
    	log.info("### usuarioLogado.getUserName(): " + userName);
        log.info("### endereco: "+endereco.toString());
        
        boolean checkDataAlteracao = enderecoService.checkUltimaAlteracao(endereco.getIdStelo());
        log.info("### checkDataAlteracao: "+checkDataAlteracao);
        if(!checkDataAlteracao) {
        	return new ResponseEntity<>(ResponseMessage.builder().message("Dados do Endereço da loja já foram alterados").build(), HttpStatus.BAD_REQUEST);        	
        }
        
    	boolean updated = enderecoService.updateEndereco(endereco, userName);
		if(updated) {
			return new ResponseEntity<>(ResponseMessage.builder().message("Endereço da loja alterado com sucesso").build(), HttpStatus.OK);	
		}
		return new ResponseEntity<>(ResponseMessage.builder().message("Não foi possível alterar o endereço da loja").build(),HttpStatus.BAD_REQUEST);
	}
    
    private String errorMsg(Errors errors) {
    	String errorMsg = errors
    	          .getAllErrors()
    	          .stream()
    	          .map(ObjectError::getDefaultMessage)
    	          .collect(Collectors.joining("; "));
    	return errorMsg;
    }
    
}
