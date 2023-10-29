package com.example.demo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class GetAllBrandsResponse {
	private int id;
	private String name;
	public GetAllBrandsResponse(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public GetAllBrandsResponse() {
		
	}
}
