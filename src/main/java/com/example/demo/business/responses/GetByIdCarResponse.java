package com.example.demo.business.responses;

import java.util.List;

import com.example.demo.entities.concretes.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdCarResponse {
	private int id;
	private String plate;
	private double dailyPrice;
	private String state;
	private double kilometer;
	private List<Model> models;
}
