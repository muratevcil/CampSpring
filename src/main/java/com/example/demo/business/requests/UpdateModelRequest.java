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
public class UpdateModelRequest {
	private int id;
	private int brandId;
	private String name;
	private int modelYear;
}
