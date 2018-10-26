package br.com.stelo.vendedor.cadastro.repositoryadapters.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "TB_SUBCATEG", schema = "USR_ICOR")
public class SubCategoriaEntity implements Serializable {

	private static final long serialVersionUID = -6618602709446913139L;

	@Id
	@Column(name = "ID_SUBCATEG", nullable = false)
	private long idSubCategoria;

	@Column(name = "DS_SUBCATEG")
	private String descricao;

	@Column(name = "ID_CATEG")
	private long idCategoria;

	@Column(name = "STTUS")
	private Integer status;

	@Column(name = "DT_INCL")
	private Date dtInclusao;

	@Column(name = "DT_ALT")
	private Date dtAlteracao;

	@Column(name = "USUAR_INCL")
	private String idUsuarioInclusao;

	@Column(name = "USUAR_ALT")
	private String idUsuarioAlteracao;

	public long getIdSubCategoria() {
		return idSubCategoria;
	}

	public void setIdSubCategoria(final long idSubCategoria) {
		this.idSubCategoria = idSubCategoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	public long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(final long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(final Integer status) {
		this.status = status;
	}

	public Date getDtInclusao() {
		return dtInclusao;
	}

	public void setDtInclusao(final Date dtInclusao) {
		this.dtInclusao = dtInclusao;
	}

	public Date getDtAlteracao() {
		return dtAlteracao;
	}

	public void setDtAlteracao(final Date dtAlteracao) {
		this.dtAlteracao = dtAlteracao;
	}

	public String getIdUsuarioInclusao() {
		return idUsuarioInclusao;
	}

	public void setIdUsuarioInclusao(final String idUsuarioInclusao) {
		this.idUsuarioInclusao = idUsuarioInclusao;
	}

	public String getIdUsuarioAlteracao() {
		return idUsuarioAlteracao;
	}

	public void setIdUsuarioAlteracao(final String idUsuarioAlteracao) {
		this.idUsuarioAlteracao = idUsuarioAlteracao;
	}

	@Override
	public String toString() {
		return "SubCategoria [idSubCategoria=" + idSubCategoria + ", descricao=" + descricao + ", idCategoria="
				+ idCategoria + ", status=" + status + ", dtInclusao=" + dtInclusao + ", dtAlteracao=" + dtAlteracao
				+ ", idUsuarioInclusao=" + idUsuarioInclusao + ", idUsuarioAlteracao=" + idUsuarioAlteracao + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtAlteracao == null) ? 0 : dtAlteracao.hashCode());
		result = prime * result + ((dtInclusao == null) ? 0 : dtInclusao.hashCode());
		result = prime * result + (int) (idCategoria ^ (idCategoria >>> 32));
		result = prime * result + (int) (idSubCategoria ^ (idSubCategoria >>> 32));
		result = prime * result + ((idUsuarioAlteracao == null) ? 0 : idUsuarioAlteracao.hashCode());
		result = prime * result + ((idUsuarioInclusao == null) ? 0 : idUsuarioInclusao.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		SubCategoriaEntity other = (SubCategoriaEntity) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtAlteracao == null) {
			if (other.dtAlteracao != null)
				return false;
		} else if (!dtAlteracao.equals(other.dtAlteracao))
			return false;
		if (dtInclusao == null) {
			if (other.dtInclusao != null)
				return false;
		} else if (!dtInclusao.equals(other.dtInclusao))
			return false;
		if (idCategoria != other.idCategoria)
			return false;
		if (idSubCategoria != other.idSubCategoria)
			return false;
		if (idUsuarioAlteracao == null) {
			if (other.idUsuarioAlteracao != null)
				return false;
		} else if (!idUsuarioAlteracao.equals(other.idUsuarioAlteracao))
			return false;
		if (idUsuarioInclusao == null) {
			if (other.idUsuarioInclusao != null)
				return false;
		} else if (!idUsuarioInclusao.equals(other.idUsuarioInclusao))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

}