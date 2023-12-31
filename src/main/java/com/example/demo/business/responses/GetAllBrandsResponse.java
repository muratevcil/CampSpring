package com.example.demo.business.responses;
import java.util.List;

import com.example.demo.entities.abstracts.ModelDetails;
import com.example.demo.entities.concretes.Model;

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
public class GetAllBrandsResponse {
	private int id;
	private String name;
	private String description;
	private List<Model> models;
}
