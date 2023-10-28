package com.example.demo.business.concrete;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.business.requests.CreateBrandRequest;
import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.dataAccess.abstracts.BrandRepository;

import java.util.ArrayList;
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
	public List<GetAllBrandsResponse> getAll(){
		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> getAllBrandsResponses = new ArrayList<GetAllBrandsResponse>();
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			getAllBrandsResponses.add(responseItem);
		}
		
		//iş kuralları
		return getAllBrandsResponses;
	}
	public void add(CreateBrandRequest createBrandRequest) {
		Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		this.brandRepository.save(brand);
	}
}
