package br.com.system.gestaoConstrucaoCivil.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends AbstractPersistable<Long> {

	
	@Column(nullable = false,length = 50)
	private String contato;
	@Column(nullable = true,length = 50)
	private String observacao;
	@ManyToOne
	@JoinColumn(name="id_dado_empresa",nullable = false)
	private DadoEmpresa dadosEmpresa;
	@Column(nullable = false)
	private boolean ativo;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		     name = "produto_fornecedor",
		     joinColumns = @JoinColumn(name = "id"),
		     inverseJoinColumns = @JoinColumn(name = "id")
		)
    private Produto produto;
	
	
	
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public String getContato() {
		return contato;
	}
	public void setContato(String contato) {
		this.contato = contato;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public DadoEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}
	public void setDadosEmpresa(DadoEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
