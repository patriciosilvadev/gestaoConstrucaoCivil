package br.com.system.gestaoConstrucaoCivil.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.system.gestaoConstrucaoCivil.service.EmpreendimentoService;

@RestController
@RequestMapping("/rest/empreendimento")
public class EmpreendimentoRestController {


	 @Autowired
	 private EmpreendimentoService empreendimentoService;
}