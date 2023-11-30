package com.microservice.cellphones.service;

import java.util.List;

import com.microservice.cellphones.entity.Cellphone;

public interface CellphoneService {
	
	public List<Cellphone> findAll();
	
	public Cellphone findById(Long id);
	
	public void deleteById(Long id);
	
	public Cellphone save(Cellphone instance);
	
	public boolean existsById(Long id);
	
}
