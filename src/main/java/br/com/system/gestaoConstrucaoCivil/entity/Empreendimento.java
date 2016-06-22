package br.com.system.gestaoConstrucaoCivil.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "empreendimento")
public class Empreendimento extends AbstractPersistable<Long> {


	@ManyToOne
	@JoinColumn(name="id_endereco_empreendimento",nullable = false)
	private Endereco enderecoEmpreendimento;
	
	@ManyToOne
	@JoinColumn(name="id_engenheiro_responsavel_funcionario",nullable = true)
	private Funcionario engenheiroResponsavelFuncionario;
	
	@ManyToOne
	@JoinColumn(name="id_engenheiro_responsavel_terceiro",nullable = true)
	private PrestadoraServico engenheiroResponsavelTerceiro;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_empreendimento",nullable = false)
	private TipoEmpreendimento tipoEmpreendimento;
    
	@Column(nullable = false)
	String descricao;
	
	@Column(nullable = false)
	private String crea;
	@Column(nullable = false)
	private Double valorMaximoGastar;
	@Column(nullable = false)
	private Double valoresGastos = 0.0;
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date dataAbertura;
	@Column(nullable = true)
	@Temporal(TemporalType.DATE)
	private Date datafechamento;
    @Column(nullable = false)
	private boolean ativo;
	
	
	public Endereco getEnderecoEmpreendimento() {
		return enderecoEmpreendimento;
	}
	public void setEnderecoEmpreendimento(Endereco enderecoEmpreendimento) {
		this.enderecoEmpreendimento = enderecoEmpreendimento;
	}
	public Funcionario getEngenheiroResponsavelFuncionario() {
		return engenheiroResponsavelFuncionario;
	}
	public void setEngenheiroResponsavelFuncionario(Funcionario engenheiroResponsavelFuncionario) {
		this.engenheiroResponsavelFuncionario = engenheiroResponsavelFuncionario;
	}
	public PrestadoraServico getEngenheiroResponsavelTerceiro() {
		return engenheiroResponsavelTerceiro;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public void setEngenheiroResponsavelTerceiro(PrestadoraServico engenheiroResponsavelTerceiro) {
		this.engenheiroResponsavelTerceiro = engenheiroResponsavelTerceiro;
	}
	public TipoEmpreendimento getTipoEmpreendimento() {
		return tipoEmpreendimento;
	}
	public void setTipoEmpreendimento(TipoEmpreendimento tipoEmpreendimento) {
		this.tipoEmpreendimento = tipoEmpreendimento;
	}
	public Double getValorMaximoGastar() {
		return valorMaximoGastar;
	}
	public void setValorMaximoGastar(Double valorMaximoGastar) {
		this.valorMaximoGastar = valorMaximoGastar;
	}
	
	public Double getValoresGastos() {
		return valoresGastos;
	}
	public void setValoresGastos(Double valoresGastos) {
		this.valoresGastos = valoresGastos;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDatafechamento() {
		return datafechamento;
	}
	public void setDatafechamento(Date datafechamento) {
		this.datafechamento = datafechamento;
	}
	
	public String getCrea() {
		return crea;
	}
	public void setCrea(String crea) {
		this.crea = crea;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
