package com.example.demo.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.CarService;
import com.example.demo.business.responses.GetAllCarsResponse;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {
	@Autowired
	private CarService carService;
	
	@GetMapping()
	public List<GetAllCarsResponse> getAll(){
		return carService.getAll();
	}
}
