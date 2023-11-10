package com.example.demo.business.rules;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.core.utilities.exceptions.BusinessException;
import com.example.demo.dataAccess.abstracts.BrandRepository;
import com.example.demo.dataAccess.abstracts.ModelRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Service
public class ModelBusinessRules {
	@Autowired
	private ModelRepository modelRepository;
	public void checkIfBrandNameExists(int id) {
		if(!modelRepository.existsById(id)) {
			throw new BusinessException("Model doesn't exists.");
		}
	}
}
