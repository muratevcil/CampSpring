package com.example.demo.business.concrete;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.business.abstracts.ModelService;
import com.example.demo.business.requests.CreateModelRequest;
import com.example.demo.business.responses.GetAllModelsResponse;
import com.example.demo.business.responses.GetByIdModelResponse;

import lombok.NoArgsConstructor;
import com.example.demo.dataAccess.abstracts.ModelRepository;
import com.example.demo.entities.concretes.Model;
import com.example.demo.core.utilities.mappers.ModelMapperService;

@Service
@NoArgsConstructor
public class ModelManager implements ModelService {
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	@Autowired
	public ModelManager(ModelRepository modelRepository, ModelMapperService modelMapperService) {
		this.modelRepository = modelRepository;
		this.modelMapperService = modelMapperService;
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
		GetByIdModelResponse getByIdModelResponse = this.modelMapperService.forResponse().map(modelRepository.findById(id), GetByIdModelResponse.class);
		return getByIdModelResponse;
	}
}
