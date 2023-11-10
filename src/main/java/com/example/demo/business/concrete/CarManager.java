package com.example.demo.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.business.abstracts.CarService;
import com.example.demo.business.requests.CreateCarRequest;
import com.example.demo.business.responses.GetAllCarsResponse;
import com.example.demo.business.responses.GetByIdCarResponse;
import com.example.demo.core.utilities.mappers.ModelMapperService;
import com.example.demo.dataAccess.abstracts.CarRepository;
import com.example.demo.entities.concretes.Car;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service

@NoArgsConstructor
public class CarManager implements CarService{
	private CarRepository carRepository;
	private ModelMapperService modelMapperService;
	
	@Autowired
	public CarManager(CarRepository carRepository,ModelMapperService modelMapperService) {
		super();
		this.carRepository = carRepository;
		this.modelMapperService = modelMapperService;
	}
	
	
	@Override
	public List<GetAllCarsResponse> getAll() {
		List<Car> cars = carRepository.findAll();
		List<GetAllCarsResponse> getAllCarsResponse = cars.stream().map(car->this.modelMapperService.forResponse().map(car,GetAllCarsResponse.class)).collect(Collectors.toList());
		return getAllCarsResponse;
	}

	@Override
	public void add(CreateCarRequest createCarRequest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GetByIdCarResponse getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}
	
}
