package br.com.system.gestaoConstrucaoCivil.repository.chamado;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.system.gestaoConstrucaoCivil.entity.Empreendimento;
import br.com.system.gestaoConstrucaoCivil.entity.Usuario;
import br.com.system.gestaoConstrucaoCivil.entity.chamado.ChamadoManutencao;
import br.com.system.gestaoConstrucaoCivil.entity.chamado.ChamadoTi;

public interface ChamadoManutencaoRepository extends JpaRepository<ChamadoManutencao, Long>{

	@Query("FROM ChamadoManutencao chamado WHERE chamado.usuarioSolicitante = :usuario AND chamado.empreendimento = :empreendimento")
	Collection<ChamadoManutencao> listaChamadoUsuario(@Param(value = "usuario") Usuario usuario, @Param(value = "empreendimento") Empreendimento empreendimento);

	@Query("FROM ChamadoManutencao chamado WHERE chamado.empreendimento = :empreendimento AND chamado.status = 'EM_ANDAMENTO' OR chamado.status = 'ABERTO'")
	Collection<ChamadoManutencao> listaSuporte(@Param(value="empreendimento") Empreendimento empreendimento);

	@Query("FROM ChamadoManutencao chamado WHERE CAST(CAST(chamado.dataAbertura as date) as string) >= :dataInicial AND CAST(CAST(chamado.dataAbertura as date) as string) <= :dataFinal")
	Collection<ChamadoManutencao> relatorio(@Param(value = "dataInicial") String dataInicial, @Param(value = "dataFinal") String dataFinal);
	
}