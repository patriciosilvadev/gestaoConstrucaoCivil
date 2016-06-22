package br.com.system.gestaoConstrucaoCivil.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;


@Entity
@Table(name = "sub_categoria")
public class SubCategoria extends AbstractPersistable<Long>{

	
	@Column(nullable = false,length = 50)
	private String descricaoSubCategoria;
	@OneToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	public String getDescricaoSubCategoria() {
		return descricaoSubCategoria;
	}
	public void setDescricaoSubCategoria(String descricaoSubCategoria) {
		this.descricaoSubCategoria = descricaoSubCategoria;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
