package com.luciano.carros.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luciano.carros.domain.carros;
import com.luciano.carros.services.servicesCarros;

@RestController
@RequestMapping(value="carros")
public class carrosResource {
	
	
	@Autowired
	private servicesCarros service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<carros> buscar(@PathVariable Integer id){
		carros C = service.buscar(id);
		
		return ResponseEntity.ok().body(C);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<carros>> findAll(){
		List<carros> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody carros C){
		C = service.insert(C);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				buildAndExpand(C.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody carros C, @PathVariable Integer id){
		C.setId(id);
		C = service.update(C);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}


