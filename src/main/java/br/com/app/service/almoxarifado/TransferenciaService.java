package br.com.app.service.almoxarifado;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.app.entity.almoxarifado.Transferencia;
import br.com.app.pojo.CancelamentoTransferencia;
import br.com.app.pojo.SessionUsuario;
import br.com.app.repository.almoxarifado.TransferenciaRepository;



@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class TransferenciaService {
	
	@Autowired
	private TransferenciaRepository transferenciaRepository;
	@Autowired
	private BaixaEstoqueService baixarEstoque;
	@Autowired 
	private EntradaEstoqueService entradaEstoque;
	
	
	@Transactional(readOnly = false)
	public void salvarAlterar(Transferencia transferencia) {

        transferencia.novaTransferencia();
        baixarEstoque.baixar(transferencia);
		transferenciaRepository.save(transferencia);
	}
	@Transactional(readOnly = false)
	public void aceitarTransferencia(Long numeroNota)
	{
		Transferencia transferencia =  transferenciaRepository.buscarTransferenciaPorNumeroNota(numeroNota);
		transferencia.aceitarTransferencia();
		entradaEstoque.entradaEstoque(transferencia);
	    transferenciaRepository.save(transferencia);
	   
	  
	   
	}
	@Transactional(readOnly = false)
	public void rejeitarTransferencia(Long numeroNota)
	{
		Transferencia transferencia =  transferenciaRepository.buscarTransferenciaPorNumeroNota(numeroNota);
		transferencia.rejeitarTransferencia();
		CancelamentoTransferencia cancelamento = new CancelamentoTransferencia(transferencia);
		entradaEstoque.entradaEstoque(cancelamento);
		transferenciaRepository.save(transferencia);
	}
	
	public Collection<Transferencia> buscarTodos(){
		return transferenciaRepository.findAll();
	}

	public Optional<Transferencia> buscaPorId(Long id){
		return transferenciaRepository.findById(id);
	}
	
	public Collection<Transferencia>  buscarTransferenciaRecebida() {
		
		return transferenciaRepository
				.buscarTransferenciaRecebidas(SessionUsuario.getInstance().getUsuario().getEmpreendimento().getId());
	}
	
	public Collection<Transferencia>  buscarTransferenciaEnviada() {
		
		return transferenciaRepository
				.buscarTransferenciaEnviada(SessionUsuario.getInstance().getUsuario().getEmpreendimento().getId());
	}
	
	public Page<Transferencia> buscarRecebidaComPaginacao(PageRequest pageRequest) {
		return transferenciaRepository
				.buscarTransferenciaRecebidasComPaginacao(SessionUsuario.getInstance().getUsuario().getEmpreendimento().getId(), pageRequest);
	}
	
	public Page<Transferencia> buscarEnviadaComPaginacao(PageRequest pageRequest) {
		return transferenciaRepository
				.buscarTransferenciaEnviadaComPaginacao(SessionUsuario.getInstance().getUsuario().getEmpreendimento().getId(), pageRequest);
	}
	
}