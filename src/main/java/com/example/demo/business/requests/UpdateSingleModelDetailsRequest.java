package com.example.demo.business.requests;

import java.util.HashMap;

import org.hibernate.mapping.Any;

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
public class UpdateSingleModelDetailsRequest {
	private int id;
	private String attributeName;
	private Object attributeValue;
}
