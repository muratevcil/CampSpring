package com.example.demo.business.responses;

import java.util.List;

import com.example.demo.entities.concretes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarsResponse {
	private int id;
	private String plate;
	private double dailyPrice;
	private int state;
	private double kilometer;
	private int brandId;
	private String brandName;
	private String modelName;
}
