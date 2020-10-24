package com.escalab.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.escalab.model.Supervisor;
import com.escalab.service.ISupervisorService;

@RestController
@RequestMapping("/supervisores")
public class SupervisorController {

	@Autowired
	private ISupervisorService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Supervisor> listarPorId(@PathVariable("id") Integer id) {
		Supervisor sup = service.leerPorId(id);
		return new ResponseEntity<Supervisor>(sup, HttpStatus.OK);
	}
	
	@GetMapping("/pageable")
	public ResponseEntity<Page<Supervisor>> listarPageable(Pageable pageable) {
		Page<Supervisor> supervisor = service.listarPageable(pageable);
		return new ResponseEntity<Page<Supervisor>>(supervisor, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> registrar(@Valid @RequestBody Supervisor supervisor) {
		Supervisor sup = service.registrar(supervisor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(supervisor.getIdSupervisor()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Supervisor> modificar(@Valid @RequestBody Supervisor supervisor) {
		Supervisor sup = service.modificar(supervisor);
		return new ResponseEntity<Supervisor>(sup, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) {
		Supervisor sup = service.leerPorId(id);
		service.eliminar(id);
		return new ResponseEntity<Object>(HttpStatus.OK);
		
	}
}
