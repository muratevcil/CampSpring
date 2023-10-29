package com.example.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/  //I removed lombok annotations becouse of the delay in build time.
public class CreateBrandRequest {
	private String name;

	public CreateBrandRequest(String name) {
		super();
		this.name = name;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
