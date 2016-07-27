app.factory('adminSistemaService', function($rootScope, toastr, $http, $q){
	
	
	return{
		
		buscarEmpresa: function(param){
			console.log("service admin" );
			return $http.get('rest/adminSistema/cadastrarEmpresa/listarEmpresaId/'+param)
			.then(function(response){
				return response.data;
			});
			
		},
		
		empresaFindAll: function(){
			return $http.get('rest/adminSistema/cadastrarEmpresa/listarEmpresa')
			.then(function(response){
				return response.data;
			},function(errResponse){
				toastr.error('Erro ao Buscar Empresas');
				console.error('Erro ao tentar buscar Empresa');
				return $q.reject(errResponse);
			});
		},
		
		
		empresaCreate: function(empresa){
			return $http.post('rest/adminSistema/cadastrarEmpresa', empresa)
			
			.then(function(response){
				console.log("teste");
				toastr.info('Empresa cadastrado');
				return response.data;
			
			},function(errResponse){
				console.error('Erro ao tentar gravar empresa');
				toastr.error('Empresa não cadastrado');
				return $q.reject(errResponse);
				
			});
		},
		
		empresaFindOne: function(id){
			return $http.get('rest/adminSistema/buscaEmpresa' +id)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar Buscar empresa');
				return $q.reject(errResponse);
			});
		},
		empresaUpdate: function(item, id){
			return $http.put('/rest/adminSistema/updateEmpresa' +id, item)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar Alterar empresa');
				return $q.reject(errResponse);
			});
		},
		empresaDelete: function(id){
			return $http.delete('/rest/adminSistema/deletarEmpresa' +id)
			.then(function(response){
				return response.data;
			},function(errResponse){
				console.error('Erro ao tentar apagar empresa');
				return $q.reject(errResponse);
			});
		}
	}
});