package com.example.demo.dataAccess.abstracts;

import java.util.List;

import com.example.demo.entities.concretes.Brand;

public interface BrandRepository {
	List<Brand> getAll();
}
