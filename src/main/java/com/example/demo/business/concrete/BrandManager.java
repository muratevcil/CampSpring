package com.example.demo.business.concrete;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.dataAccess.abstracts.BrandRepository;

import java.util.List;
import com.example.demo.entities.concretes.*;
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override //we write override to declare we are overloading an existing method. In this case that existing method comes from interface.
	public List<Brand> getAll(){
		//iş kuralları
		return brandRepository.getAll();
	}
}
