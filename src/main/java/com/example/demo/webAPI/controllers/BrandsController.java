 package com.example.demo.webAPI.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.business.abstracts.BrandService;
import com.example.demo.entities.concretes.Brand;

@RestController  //annotation
@RequestMapping("/api/brands")
public class BrandsController{
	private BrandService brandService;
	
	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}
	 
	@GetMapping("/getAll")
	public List<Brand> getAll() {
		return brandService.getAll();
	}
}
