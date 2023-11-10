package com.example.demo.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Table(name="cars")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="plate" , unique = true)
	private String plate;
	
	@Column(name="dailyPrice")
	private double dailyPrice;
	
	@Column(name="state")
	private int state;  //1- Available 2- Rented 3- Maintenance
	
	@Column(name="kilometer")
	private double kilometer;
	
	@ManyToOne // {Geldiği yer}To{Gittiği Yer} (Birden çok arabanın tek bi markası olabilir)
	@JoinColumn(name="model")
	@JsonIgnore
	private Model model; // model içerisinde brand bilgisi de olduğu için modeli almamız yeterli olacaktır.
}
