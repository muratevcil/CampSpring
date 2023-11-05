package com.example.demo.business.concrete;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.business.requests.CreateBrandRequest;
import com.example.demo.business.requests.UpdateBrandRequest;
import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.business.responses.GetByIdBrandResponse;
import com.example.demo.business.rules.BrandBusinessRules;
import com.example.demo.core.utilities.mappers.ModelMapperService;
import com.example.demo.dataAccess.abstracts.BrandRepository;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.concretes.Brand;

@Service //bu sınıf bir business nesnesidir

public class BrandManager implements BrandService {
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;
	
	@Autowired
	public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService,BrandBusinessRules brandBusinessRules) {
		super();
		this.brandRepository=brandRepository;
		this.modelMapperService=modelMapperService;
		this.brandBusinessRules = brandBusinessRules;

	}
	public BrandManager() {
		
	}
	@Override //we write override to declare we are overloading an existing method. In this case that existing method comes from interface.
	public List<GetAllBrandsResponse> getAll(){
		List<Brand> brands = brandRepository.findAll();
		//List<GetAllBrandsResponse> getAllBrandsResponses = new ArrayList<GetAllBrandsResponse>();
		/*
		 * for (Brand brand : brands) { GetAllBrandsResponse responseItem = new
		 * GetAllBrandsResponse(); responseItem.setId(brand.getId());
		 * responseItem.setName(brand.getName());
		 * getAllBrandsResponses.add(responseItem); }
		 */
		//				|
		//				|
		//				|
		//			Bunu Mapper ile daha kolay yapabiliriz.
		
		
		List<GetAllBrandsResponse> getAllBrandsResponses = brands.stream().map(brand->this.modelMapperService.forResponse().map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());		//Stream sayesinde alınan bütün brandleri tek tek dolaşıyor.

		return getAllBrandsResponses;
	}
	public void add(CreateBrandRequest createBrandRequest) {
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}
	
	public GetByIdBrandResponse getById(int id) {
		this.brandBusinessRules.checkIfBrandNameNotExists(id);
		GetByIdBrandResponse getByIdBrandResponse = this.modelMapperService.forResponse().map(brandRepository.findById(id),GetByIdBrandResponse.class);
		return getByIdBrandResponse;
	}
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest,Brand.class);
		this.brandRepository.save(brand);
	}
	public void delete(int id) {
		this.brandRepository.deleteById(id);
	}
	
}
