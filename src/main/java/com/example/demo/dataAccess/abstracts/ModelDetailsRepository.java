package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.abstracts.ModelDetails;

public interface ModelDetailsRepository extends JpaRepository<ModelDetails, Integer> {
	public ModelDetails findById(int id);
}
