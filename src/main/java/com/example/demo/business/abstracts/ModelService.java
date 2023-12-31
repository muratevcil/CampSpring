package com.example.demo.business.abstracts;
import java.util.List;
import com.example.demo.business.requests.CreateModelRequest;
import com.example.demo.business.requests.UpdateModelRequest;
import com.example.demo.business.responses.GetAllModelsResponse;
import com.example.demo.business.responses.GetByIdModelDetailsResponse;
import com.example.demo.business.responses.GetByIdModelResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
	GetByIdModelResponse getById(int id);
	void update(UpdateModelRequest updateModelRequest);
	void delete(int id);
}
