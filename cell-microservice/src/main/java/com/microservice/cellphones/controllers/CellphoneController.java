package com.microservice.cellphones.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.cellphones.entity.Cellphone;
import com.microservice.cellphones.service.CellphoneService;

@RestController
public class CellphoneController {
	
	@Autowired
	private CellphoneService service;
	
//	@Value("${server.port}")
//	private Integer port;
	
	@Autowired
	private Environment env;
	
	@GetMapping("/list")
	public List<Cellphone> list() {
		return service.findAll().stream().map(cel -> {
			cel.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return cel;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/cellphone/{id}")
	public Cellphone getPhone(@PathVariable Long id) {
//		boolean val = false;
//		if (!val) {
//			throw new RuntimeException("Can't find detail");
//		}
//		try {
//			Thread.sleep(2000L);
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		return service.findById(id);
	}
	
	@DeleteMapping("/cellphone/{id}")
	public ResponseEntity<Void> drop(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/cellphone")
	public ResponseEntity<Cellphone> add(@RequestBody Cellphone instance) {
		Cellphone cell = service.save(instance);
		return new ResponseEntity<>(cell, HttpStatus.CREATED);
	}
	
	@PutMapping("/cellphone/{id}")
	public ResponseEntity<Cellphone> update(@PathVariable Long id, @RequestBody Cellphone instance) {
		if(service.existsById(id)) {
			instance.setId(id);
			Cellphone cell = service.save(instance);
			return new ResponseEntity<>(cell, HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
