package br.com.stelo.vendedor.cadastro.models;

public class Loja {

	private long idStelo;
	private long idSubCategoria;
	private long idCategoria;
	
	public long getIdStelo() {
		return idStelo;
	}

	public void setIdStelo(long idStelo) {
		this.idStelo = idStelo;
	}

	public long getIdSubCategoria() {
		return idSubCategoria;
	}

	public void setIdSubCategoria(final long idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(final long idCategoria) {
		this.idCategoria = idCategoria;
	}

	@Override
	public String toString() {
		return "Loja [idStelo=" + idStelo + ", idSubCategoria=" + idSubCategoria + ", idCategoria=" + idCategoria
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idCategoria ^ (idCategoria >>> 32));
		result = prime * result + (int) (idStelo ^ (idStelo >>> 32));
		result = prime * result + (int) (idSubCategoria ^ (idSubCategoria >>> 32));
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
		Loja other = (Loja) obj;
		if (idCategoria != other.idCategoria)
			return false;
		if (idStelo != other.idStelo)
			return false;
		if (idSubCategoria != other.idSubCategoria)
			return false;
		return true;
	}

}
