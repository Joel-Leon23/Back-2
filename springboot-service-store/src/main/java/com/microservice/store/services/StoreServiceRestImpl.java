package com.microservice.store.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.store.models.Cellphone;
import com.microservice.store.models.Store;

@Service
public class StoreServiceRestImpl implements StoreService {
	
	@Autowired
	private RestTemplate clientRest;
	
	@Override
	public List<Store> findAll() {
		return Arrays.asList(clientRest.getForObject("http://localhost:8081/list", Cellphone[].class)).stream().map(c -> new Store(c, 5)).collect(Collectors.toList());
	}
	
	@Override
	public Store findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Cellphone cel = clientRest.getForObject("http://localhost:8081/cellphone/{id}", Cellphone.class, pathVariables);
		return new Store(cel, quantity);
	}
}
