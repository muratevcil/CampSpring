 package com.example.demo.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.business.abstracts.BrandService;
import com.example.demo.business.requests.CreateBrandRequest;
import com.example.demo.business.requests.UpdateBrandRequest;
import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.business.responses.GetByIdBrandResponse;
@RestController  //annotation
@RequestMapping("/api/brands")
public class BrandsController{
	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	 
	public BrandsController() {
		
	}
	@GetMapping()	
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}
	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody() UpdateBrandRequest updateBrandRequest) {
		this.brandService.update(updateBrandRequest);
	}
	@PostMapping("/delete/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id) {
		this.brandService.delete(id);
	}
}
