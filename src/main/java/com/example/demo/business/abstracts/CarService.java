package com.example.demo.business.abstracts;

import java.util.List;

import com.example.demo.business.requests.CreateCarRequest;
import com.example.demo.business.responses.GetAllCarsResponse;
import com.example.demo.business.responses.GetByIdCarResponse;

public interface CarService {
	List<GetAllCarsResponse> getAll();
	void add(CreateCarRequest createCarRequest);
	GetByIdCarResponse getById(int id);
	void delete(int id);
}
