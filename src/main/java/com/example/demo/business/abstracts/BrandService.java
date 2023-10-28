package com.example.demo.business.abstracts;

import com.example.demo.business.requests.CreateBrandRequest;
import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	
}
	
