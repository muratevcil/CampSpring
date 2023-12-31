package com.example.demo.business.responses;

import com.example.demo.entities.abstracts.ModelDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetByIdModelResponse {
	private int id;
	private String name;
	private String brandId;  
	private String brandDescription;
	private ModelDetails modelDetails;
}
	
