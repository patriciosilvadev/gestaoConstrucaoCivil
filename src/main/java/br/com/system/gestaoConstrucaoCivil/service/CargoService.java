package br.com.system.gestaoConstrucaoCivil.service;

import java.util.List;

import javax.websocket.Session;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import br.com.system.gestaoConstrucaoCivil.entity.Cargo;
import br.com.system.gestaoConstrucaoCivil.repository.CargoRepository;
import br.com.system.gestaoConstrucaoCivil.service.servicos.Servico;

@Service
@EnableCaching(proxyTargetClass = true)
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class CargoService implements Servico<Cargo> {

	@Autowired
	private CargoRepository cargoRepository;
	
	@Transactional(readOnly = false)
	public void salvarOuEditar(Cargo cargo)
	{
		cargoRepository.save(cargo);
	}
	
    public List<Cargo> buscarTodos(){
		
		return cargoRepository.findAll();
	}
    public Cargo buscarPorId(Long id)
    {
    	return cargoRepository.findOne(id);
    }
}
