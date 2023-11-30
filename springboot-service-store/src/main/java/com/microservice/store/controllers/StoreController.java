package com.microservice.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.store.models.Store;
import com.microservice.store.services.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/list")
	public List<Store> list() {
		return storeService.findAll();
	}
	
	@GetMapping("/cellphone/{id}/quantity/{quantity}")
	public Store details(@PathVariable Long id, @PathVariable Integer quantity) {
		return storeService.findById(id, quantity);
	}
	
}
