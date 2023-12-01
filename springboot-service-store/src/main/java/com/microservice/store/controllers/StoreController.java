package com.microservice.store.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.store.models.Cellphone;
import com.microservice.store.models.Store;
import com.microservice.store.services.StoreService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/list")
	public List<Store> list() {
		return storeService.findAll();
	}
	
	@HystrixCommand(fallbackMethod="genericMethod")
	@GetMapping("/cellphone/{id}/quantity/{quantity}")
	public Store details(@PathVariable Long id, @PathVariable Integer quantity) {
		return storeService.findById(id, quantity);
	}
	
	
	public Store genericMethod(Long id, Integer quantity) {
		Cellphone cel = new Cellphone(id, "New cel", "New brand");
		return new Store(cel, quantity);
	}
}
