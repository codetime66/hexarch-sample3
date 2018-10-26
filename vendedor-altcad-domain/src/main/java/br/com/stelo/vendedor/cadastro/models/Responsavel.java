package br.com.stelo.vendedor.cadastro.models;

import org.springframework.validation.annotation.Validated;

import br.com.stelo.vendedor.cadastro.models.constraints.BroadFields;

@Validated
public class Responsavel {

	private long idStelo;
    
	private String name;
    
    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.CPFValidator",
    		message="{br.com.stelo.vendedor-altcad.cpf.message}"
    		)
    private String cpf;

    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.DateValidator",
    		message="{br.com.stelo.vendedor-altcad.birthdate}"
    		)
    private String birthDate;

    @BroadFields(
    		checkclass="br.com.stelo.vendedor.cadastro.models.constraints.EmailValidator",
    		message="{br.com.stelo.vendedor-altcad.email}"
    		)    
    private String email;
	
	public long getIdStelo() {
		return idStelo;
	}

	public void setIdStelo(long idStelo) {
		this.idStelo = idStelo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Responsavel [idStelo=" + idStelo + ", name=" + name + ", cpf=" + cpf + ", birthDate=" + birthDate
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idStelo ^ (idStelo >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Responsavel other = (Responsavel) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idStelo != other.idStelo)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	
}
