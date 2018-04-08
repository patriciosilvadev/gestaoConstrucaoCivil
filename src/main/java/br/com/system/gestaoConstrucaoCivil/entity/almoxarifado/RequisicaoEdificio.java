package br.com.system.gestaoConstrucaoCivil.entity.almoxarifado;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.system.gestaoConstrucaoCivil.entity.Empreendimento;

@Entity
@SequenceGenerator(name = "requisicao_edificio_seq", sequenceName = "requisicao_edificio_seq", schema = "almoxarifado", initialValue = 1, allocationSize = 1)
@Table(name = "requisicao_edificio", schema = "almoxarifado")
public class RequisicaoEdificio implements IRequisicao<RequisicaoEdificioItem> {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "requisicao_edificio_seq")
	private Long id;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_informacao_requisicao", nullable = true)
	private InformacaoRequisicao informacaoRequisicao;

	@OneToMany(mappedBy = "requisicaoEdificio", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<RequisicaoEdificioItem> itens;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<RequisicaoEdificioItem> getItens() {
		return itens;
	}

	public void setItens(List<RequisicaoEdificioItem> itens) {

		this.itens = itens;

		for (RequisicaoEdificioItem item : this.itens) {
			item.setRequisicaoEdificio(this);
		}
	}

	public InformacaoRequisicao getInformacaoRequisicao() {
		return informacaoRequisicao;

	}

	public void setInformacaoRequisicao(InformacaoRequisicao informacaoRequisicao) {
		this.informacaoRequisicao = informacaoRequisicao;
	}

	@Override
	public Empreendimento empreendimentoSaida() {

		return informacaoRequisicao.getEmpreendimento();
	}

	@Override
	public Empreendimento empreendimentoEntrada() {

		return informacaoRequisicao.getEmpreendimento();
	}

}
