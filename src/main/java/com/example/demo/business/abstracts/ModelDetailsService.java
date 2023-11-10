package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.requests.CreateModelDetailsRequest;
import com.example.demo.business.requests.UpdateModelDetailsRequest;
import com.example.demo.business.requests.UpdateSingleModelDetailsRequest;
import com.example.demo.business.responses.GetAllModelDetailsResponse;
import com.example.demo.business.responses.GetByIdModelDetailsResponse;

public interface ModelDetailsService {
	List<GetAllModelDetailsResponse> getAll();
	GetByIdModelDetailsResponse getByIdModelDetails(int id);
	void add(CreateModelDetailsRequest createModelDetailsRequest);
	void update(UpdateModelDetailsRequest updateModelDetailsRequest);
	void delete(int id);
	void updateSingleAttribute(UpdateSingleModelDetailsRequest updateSingleModelDetailsRequest);
}
