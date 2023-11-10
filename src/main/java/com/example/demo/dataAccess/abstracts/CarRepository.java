package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Integer> {

}
