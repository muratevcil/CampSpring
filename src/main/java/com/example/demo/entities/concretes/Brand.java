package com.example.demo.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor  //Lombok sayesinde getter ve setterları koyduk.
@AllArgsConstructor
@Table(name="brands")
@Entity
public class Brand {
	@Id  //primary key olduğunu belli eder
	@GeneratedValue(strategy = GenerationType.IDENTITY) //UUID generates a new Id. IDENTITY automatically increments.
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
}
