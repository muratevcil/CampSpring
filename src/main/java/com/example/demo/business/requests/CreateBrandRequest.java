package com.example.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/  //I removed lombok annotations becouse of the delay in build time.
@NoArgsConstructor
public class CreateBrandRequest {
	private String name;
	private String description;

	public CreateBrandRequest(String name,String description) {
		super();
		this.name = name;
		this.description = description;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
