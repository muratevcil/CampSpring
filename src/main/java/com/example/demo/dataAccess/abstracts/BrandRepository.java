package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.entities.concretes.Brand;


public interface BrandRepository extends JpaRepository<Brand, Integer> {

	
	
	
}
