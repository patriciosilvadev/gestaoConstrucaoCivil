
app.config(['$routeProvider', '$httpProvider', function($routeProvider,  $httpProvider) {
	

	$routeProvider
	
	
	
	.when('/servicos/vincular/cadastro', {
		templateUrl:"views/pages/modulo_servicos/vincular/cadastro.html",		
	})
	.when('/servicos/vincular/listagem', {
		templateUrl:"views/pages/modulo_servicos/vincular/listagem.html",		
	})
	.when('/servicos/vincular/visualizar/casa/:idServicoCasa', {
		templateUrl:"views/pages/modulo_servicos/vincular/visualizarCasa.html",		
	})
	.when('/servicos/vincular/visualizar/edificio/:idServicoEdificio', {
		templateUrl:"views/pages/modulo_servicos/vincular/visualizarEdificio.html",		
	})
	.when('/servicos/vincular/visualizar/comunitario/:idServicoComunitario', {
		templateUrl:"views/pages/modulo_servicos/vincular/visualizarComunitario.html",		
	})
	
	.when('/servicos/vincular/relatorio', {
		templateUrl:"views/pages/modulo_servicos/vincular/servicos.relatorio.html",		
	})
	
	
	
	.when('/servicos/vistoria', {
		templateUrl:"views/pages/modulo_servicos/vistoria/vistoria.form.html",		
	})	
	.when('/servicos/vistoria/visualizar/casa/:idServicoCasa', {
		templateUrl:"views/pages/modulo_servicos/vistoria/visualizarVistoriaCasa.html",		
	})
	.when('/servicos/vistoria/visualizar/edificio/:idServicoEdificio', {
		templateUrl:"views/pages/modulo_servicos/vistoria/visualizarVistoriaEdificio.html",		
	})
	.when('/servicos/vistoria/visualizar/comunitario/:idServicoComunitario', {
		templateUrl:"views/pages/modulo_servicos/vistoria/visualizarVistoriaComunitario.html",		
	})
	
	.when('/servicos/pagamento/cadastrar', {
		templateUrl:"views/pages/modulo_servicos/pagamento/pagamento.form.html",		
	})	
	.when('/servicos/pagamento/cadatrar/:idServico', {
		templateUrl:"views/pages/modulo_servicos/pagamento/pagamentoVistoria.html",		
	})
	.when('/servicos/vistoria/pagamento/edificio/:idServicoEdificio', {
		templateUrl:"views/pages/modulo_servicos/pagamento/pagamentoVistoriaEdificio.html",		
	})
	.when('/servicos/vistoria/pagamento/comunitario/:idServicoComunitario', {
		templateUrl:"views/pages/modulo_servicos/pagamento/pagamentoVistoriaComunitario.html",		
	})
	
}]);



