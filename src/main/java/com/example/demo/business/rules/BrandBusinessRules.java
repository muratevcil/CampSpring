package com.example.demo.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.core.utilities.exceptions.BusinessException;
import com.example.demo.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class BrandBusinessRules {
	@Autowired
	private BrandRepository brandRepository;
	public void checkIfBrandNameExists(String name) {
		if(brandRepository.existsByName(name)) {
			throw new BusinessException("Brand already exists.");
		}
	}
	public void checkIfBrandNameNotExists(int id) {
		if(!brandRepository.existsById(id)) {
			throw new BusinessException("404.Brand not exists.");
		}
	}
}
