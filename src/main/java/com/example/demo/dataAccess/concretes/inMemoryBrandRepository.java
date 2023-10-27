package com.example.demo.dataAccess.concretes;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.example.demo.dataAccess.abstracts.BrandRepository;

import com.example.demo.entities.concretes.Brand;
import java.util.ArrayList;

@Repository //bu sınıf bir data access nesnesidir.
public class inMemoryBrandRepository implements BrandRepository {
	List<Brand> brands;
	public inMemoryBrandRepository() {
		brands = new ArrayList<Brand>();
		brands.add(new Brand(1,"BMW"));
		brands.add(new Brand(2,"Mercedes"));
		brands.add(new Brand(3,"Audi"));
		brands.add(new Brand(4,"Fiat"));
		brands.add(new Brand(5,"Renault"));
	}
	//commit test
	public List<Brand> getAll(){
		return brands;	
	}
	
}
