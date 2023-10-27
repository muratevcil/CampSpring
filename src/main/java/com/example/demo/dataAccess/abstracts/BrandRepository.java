package com.example.demo.dataAccess.abstracts;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.concretes.Brand;

@Repository

public interface BrandRepository {
	List<Brand> getAll();
}
