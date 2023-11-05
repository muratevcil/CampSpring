package com.example.demo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.concretes.Model;
public interface ModelRepository extends JpaRepository<Model,Integer> {
}
