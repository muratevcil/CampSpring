package com.example.demo.business.requests;

import com.example.demo.entities.concretes.Model;

import lombok.Data;

@Data
public class CreateCarRequest {
	private String plate;
	private String state;
	private double kilometer;
	private double dailyPrice;
	private Model model;
	
}
