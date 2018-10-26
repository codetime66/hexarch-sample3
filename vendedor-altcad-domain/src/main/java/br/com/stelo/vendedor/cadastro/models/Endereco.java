package br.com.stelo.vendedor.cadastro.models;

import org.springframework.validation.annotation.Validated;

import br.com.stelo.vendedor.cadastro.models.constraints.BroadFields;

@Validated
public class Endereco {

	private long idStelo;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.CEPValidator",
    		message="{br.com.stelo.vendedor-altcad.cep.message}"
    		)
	private String cep;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.EnderecoValidator",
    		message="{br.com.stelo.vendedor-altcad.endereco.message}"
    		)    
    private String endereco;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.NumeroValidator",
    		message="{br.com.stelo.vendedor-altcad.numero.message}"
    		)
    private String numero;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.ComplementoValidator",
    		message="{br.com.stelo.vendedor-altcad.complemento.message}"
    		)
    private String complemento;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.BairroValidator",
    		message="{br.com.stelo.vendedor-altcad.bairro.message}"
    		)    
    private String bairro;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.UFValidator",
    		message="{br.com.stelo.vendedor-altcad.uf.message}"
    		)
    private String estado;

    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.CidadeValidator",
    		message="{br.com.stelo.vendedor-altcad.cidade.message}"
    		)    
    private String cidade;
	
	public long getIdStelo() {
		return idStelo;
	}

	public void setIdStelo(long idStelo) {
		this.idStelo = idStelo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@Override
	public String toString() {
		return "Endereco [idStelo=" + idStelo + ", cep=" + cep + ", endereco=" + endereco + ", numero=" + numero
				+ ", complemento=" + complemento + ", bairro=" + bairro + ", estado=" + estado + ", cidade=" + cidade
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + (int) (idStelo ^ (idStelo >>> 32));
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (idStelo != other.idStelo)
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
