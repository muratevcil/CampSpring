package com.example.demo.dataAccess.abstracts;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.concretes.Brand;
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}