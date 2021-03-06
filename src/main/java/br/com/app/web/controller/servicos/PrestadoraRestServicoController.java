package br.com.app.web.controller.servicos;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.app.entity.servicos.PrestadoraServico;
import br.com.app.service.servicos.PrestadoraServicoService;

@RestController
@RequestMapping("/rest/servicos/prestadoraServico")
public class PrestadoraRestServicoController {

	@Autowired
	private PrestadoraServicoService prestadoraServicoService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/lista")
	public Collection<PrestadoraServico> buscarTodos() {
		return prestadoraServicoService.lista();
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping
	public Page<PrestadoraServico> lista(@RequestParam(defaultValue = "0", required = false) int page,
			@RequestParam(defaultValue = "0", required = false) int maxResults) {
		return prestadoraServicoService.buscarTodos(new PageRequest(page, maxResults));

	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/buscaPorId/{id}")
	public Optional<PrestadoraServico> buscarPorId(@PathVariable Long id) {
		return prestadoraServicoService.buscarPorId(id);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/salva")
	public void salvar(@RequestBody PrestadoraServico prestadoraServico) {

		prestadoraServicoService.salvarOuEditar(prestadoraServico);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping(value = "/altera")
	public void alterar(@RequestBody PrestadoraServico prestadoraServico) {

		prestadoraServicoService.salvarOuEditar(prestadoraServico);
	}
}
