package com.example.demo.business.responses;

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
public class GetByIdModelDetailsResponse {
	private int id;
	private int modelId;
	private int airBagType;
	private int backDoorType;
	private double engine_volume;
	private boolean isLowerCeiling;
	private String yearGap;
	private int fuelType;
	private String modelDescription;
}
