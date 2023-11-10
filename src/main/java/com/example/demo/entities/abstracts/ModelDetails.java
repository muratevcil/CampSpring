package com.example.demo.entities.abstracts;

import java.lang.reflect.Field;

import com.example.demo.entities.concretes.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name="modeldetails")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ModelDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@OneToOne
	@JoinColumn(name = "model_id")  // ORM içerisinde ID ile maplenecek.
	@JsonIgnore
	private Model model;
	
	@Column(name= "yearGap")
	private String yearGap;

	@Column(name="engineVolume")
	private double engineVolume;
	
	@Column(name="isLowerCeiling")
	private boolean isLowerCeiling;
	
	@Column(name="backDoorType")
	private int backDoorType; //1- Tek sürgü 2- Çift Sürgü
	
	@Column(name="airBagType")
	private int airBagType; //1- 1 Airbag 2- 2 Airbag
	
	@Column(name="fuelType")
	private int fuelType; //1- Benzin 2- Mazot 3- LPG 4- Dizel 5- Elektrikli 6- Hibrit
	
	@Column(name = "modelDescription")
	private String modelDescription;	
	
	
	 public void generalSetter(String property, Object value) {
	        try {
	            Field field = getClass().getDeclaredField(property);
	            field.setAccessible(true);
	            field.set(this, value);
	        } catch (NoSuchFieldException | IllegalAccessException e) {
	            e.printStackTrace(); // Handle the exception according to your needs
	        }
	    }
}
