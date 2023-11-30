package com.microservice.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.store.models.Cellphone;

@FeignClient(name = "service-cellphones", url = "localhost:8081")
public interface CellphoneClientFeign {
	
	@GetMapping("/list")
	public List<Cellphone> list();

	@GetMapping("/cellphone/{id}")
	public Cellphone findById(@PathVariable Long id);
}
