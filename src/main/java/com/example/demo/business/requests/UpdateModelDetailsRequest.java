package com.example.demo.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelDetailsRequest {
	private int id;
	private int modelId;
	private int airBagType;
	private int backDoorType;
	private double engineVolume;
	private boolean isLowerCeiling;
	private String yearGap;
	private int fuelType;	
}
