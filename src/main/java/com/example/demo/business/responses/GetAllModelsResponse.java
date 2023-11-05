package com.example.demo.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelsResponse {
	private int id;
	private String name;
	private String brandId;  //Models tablosunda id,name,brandId olmasına rağmen brandName e ulaşım sağlayabiliriz.
	private String brandName;
	private String brandDescription;
}
