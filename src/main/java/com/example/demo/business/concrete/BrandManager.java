package com.example.demo.business.concrete;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.dataAccess.abstracts.BrandRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir
public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	
	@Autowired
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
