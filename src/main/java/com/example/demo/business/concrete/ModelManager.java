package com.example.demo.business.concrete;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.business.abstracts.ModelService;
import com.example.demo.business.requests.CreateModelRequest;
import com.example.demo.business.requests.UpdateModelRequest;
import com.example.demo.business.responses.GetAllModelsResponse;
import com.example.demo.business.responses.GetByIdModelDetailsResponse;
import com.example.demo.business.responses.GetByIdModelResponse;
import com.example.demo.business.rules.BrandBusinessRules;
import com.example.demo.business.rules.ModelBusinessRules;

import lombok.NoArgsConstructor;

import com.example.demo.dataAccess.abstracts.ModelDetailsRepository;
import com.example.demo.dataAccess.abstracts.ModelRepository;
import com.example.demo.entities.concretes.Model;
import com.example.demo.core.utilities.mappers.ModelMapperService;

@Service
@NoArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	private ModelBusinessRules modelBusinessRules;
	@Autowired
	public ModelManager(ModelRepository modelRepository,
						ModelMapperService modelMapperService,
						ModelBusinessRules modelBusinessRules) {
		this.modelRepository = modelRepository;
		this.modelMapperService = modelMapperService;
		this.modelBusinessRules = modelBusinessRules;
	}
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> modelsRespone = models.stream().map(model ->this.modelMapperService.forResponse().map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelsRespone;
	
	}
	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);
	}
	@Override
	public GetByIdModelResponse getById(int id) {
		this.modelBusinessRules.checkIfBrandNameExists(id);
		GetByIdModelResponse getByIdModelResponse = this.modelMapperService.forResponse().map(modelRepository.findById(id), GetByIdModelResponse.class);
		return getByIdModelResponse;
	}
	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = this.modelMapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);
		
	}
	@Override
	public void delete(int id) {
		this.modelRepository.deleteById(id);
		
	}
}
