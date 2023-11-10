package com.example.demo.business.concrete;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.business.abstracts.ModelDetailsService;
import com.example.demo.business.requests.CreateModelDetailsRequest;
import com.example.demo.business.requests.UpdateModelDetailsRequest;
import com.example.demo.business.requests.UpdateSingleModelDetailsRequest;
import com.example.demo.business.responses.GetByIdModelDetailsResponse;
import com.example.demo.dataAccess.abstracts.ModelDetailsRepository;
import com.example.demo.entities.abstracts.ModelDetails;
import com.example.demo.core.utilities.mappers.ModelMapperService;
import com.example.demo.business.responses.GetAllModelDetailsResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Service
@AllArgsConstructor
@NoArgsConstructor
public class ModelDetailsManager implements ModelDetailsService {
	@Autowired
	private ModelDetailsRepository modelDetailsRepository;
	@Autowired
	private ModelMapperService modelMapperService;
	@Override
	public void add(CreateModelDetailsRequest createModelDetailsRequest) {
		ModelDetails modelDetails = this.modelMapperService.forRequest().map(createModelDetailsRequest, ModelDetails.class);
		this.modelDetailsRepository.save(modelDetails);
		
	}
	@Override
	public GetByIdModelDetailsResponse getByIdModelDetails(int id) {
		GetByIdModelDetailsResponse getByIdModelDetailsResponse = this.modelMapperService.forResponse().map(modelDetailsRepository.findById(id),GetByIdModelDetailsResponse.class);
		return getByIdModelDetailsResponse;

	}
	@Override
	public List<GetAllModelDetailsResponse> getAll() {
		List<ModelDetails> modelDetails = modelDetailsRepository.findAll();
		List<GetAllModelDetailsResponse> getAllModelDetailsResponses = modelDetails.stream().map(modelDetail->this.modelMapperService.forResponse().map(modelDetail,GetAllModelDetailsResponse.class)).collect(Collectors.toList());
		return getAllModelDetailsResponses;
	}
	@Override
	public void update(UpdateModelDetailsRequest updateModelDetailsRequest) {
		ModelDetails modelDetails = this.modelMapperService.forRequest().map(updateModelDetailsRequest,ModelDetails.class);
		modelDetailsRepository.save(modelDetails);	
	}
	@Override
	public void delete(int id) {
		modelDetailsRepository.deleteById(id);
	}
	@Override
	public void updateSingleAttribute(UpdateSingleModelDetailsRequest updateSingleModelDetailsRequest) {
		ModelDetails modelDetails = modelDetailsRepository.findById(updateSingleModelDetailsRequest.getId());
		modelDetails.generalSetter(updateSingleModelDetailsRequest.getAttributeName(), updateSingleModelDetailsRequest.getAttributeValue());
		//System.out.println(modelDetails.getYearGap());
		modelDetailsRepository.save(modelDetails);
		
	}
}
