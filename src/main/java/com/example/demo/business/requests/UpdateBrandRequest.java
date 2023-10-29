package com.example.demo.business.requests;

import lombok.Data;

@Data
public class UpdateBrandRequest {
	private int id;
	private String name;
	public UpdateBrandRequest(int id,String name) {
		this.id=id;
		this.name=name;
	}
	public UpdateBrandRequest() {
		
	}
}
