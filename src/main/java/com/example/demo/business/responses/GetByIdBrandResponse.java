package com.example.demo.business.responses;

import lombok.Data;

@Data
public class GetByIdBrandResponse {
	private int id;
	private String name;
	public GetByIdBrandResponse(int id,String name) {
		this.id = id;
		this.name = name;
	}
	public GetByIdBrandResponse() {
		
	}
}
