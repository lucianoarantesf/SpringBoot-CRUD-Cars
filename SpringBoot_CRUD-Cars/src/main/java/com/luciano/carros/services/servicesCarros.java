package com.luciano.carros.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luciano.carros.domain.carros;
import com.luciano.carros.repository.ICarros;

@Service
public class servicesCarros {

	@Autowired
	private ICarros repository;
	
	public carros buscar(Integer id) {
		Optional<carros> C = repository.findById(id);
		return C.orElse(null);
	}
	
	public List<carros> findAll(){
		return repository.findAll();
	}
	
	public carros insert(carros C) {
		C.setId(null);
		return repository.save(C);
		
		
	}
	
	public carros update(carros C) {
		return repository.save(C);
	}
	
	public void delete(Integer id) {
		if(buscar(id) != null) {
			repository.deleteById(id);
		}
	}

}


