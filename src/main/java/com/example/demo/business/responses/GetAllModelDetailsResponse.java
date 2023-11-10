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
public class GetAllModelDetailsResponse {
	private int id;
	private int modelId;
	private int air_bag_type;
	private int back_door_type;
	private double engine_volume;
	private boolean is_lower_ceiling;
	private String year_gap;
	private int fuel_type;
}
