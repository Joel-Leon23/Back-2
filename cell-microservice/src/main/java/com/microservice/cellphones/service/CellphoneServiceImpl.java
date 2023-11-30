package com.microservice.cellphones.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.cellphones.entity.Cellphone;
import com.microservice.cellphones.repository.CellphoneDao;

@Service("serviceRest")
public class CellphoneServiceImpl implements CellphoneService {

	@Autowired
	private CellphoneDao cellDao;
	@Override
	public List<Cellphone> findAll() {
		return (List<Cellphone>) cellDao.findAll();
	}

	@Override
	public Cellphone findById(Long id) {
		return cellDao.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		cellDao.deleteById(id);
	}

	@Override
	public Cellphone save(Cellphone instance) {
		return cellDao.save(instance);
	}

	@Override
	public boolean existsById(Long id) {
		return cellDao.existsById(id);
	}

}
