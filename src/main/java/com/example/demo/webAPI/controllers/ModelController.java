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
import com.example.demo.business.abstracts.ModelService;
import com.example.demo.business.requests.CreateBrandRequest;
import com.example.demo.business.requests.CreateModelRequest;
import com.example.demo.business.requests.UpdateBrandRequest;
import com.example.demo.business.requests.UpdateModelRequest;
import com.example.demo.business.responses.GetAllBrandsResponse;
import com.example.demo.business.responses.GetAllModelsResponse;
import com.example.demo.business.responses.GetByIdBrandResponse;
import com.example.demo.business.responses.GetByIdModelResponse;
import com.example.demo.dataAccess.abstracts.ModelRepository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/api/models")
public class ModelController {
	public ModelService modelService;
	public ModelRepository modelRepository;
	public ModelController(ModelService modelService,ModelRepository modelRepository) {
		this.modelService = modelService;
		this.modelRepository = modelRepository;
	}
	@GetMapping()
	public List<GetAllModelsResponse> getAll(){
		return modelService.getAll();
	}
	@GetMapping("/{id}")
	@ResponseStatus(code=HttpStatus.ACCEPTED)
	public GetByIdModelResponse getById(@PathVariable int id) {
		return this.modelService.getById(id);
		
	}
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	@PutMapping()
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void update(@RequestBody() UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	@PostMapping("/delete/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void delete(@PathVariable int id) {
		this.modelService.delete(id);
	}
}
