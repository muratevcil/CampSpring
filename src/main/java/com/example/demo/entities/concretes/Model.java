package com.example.demo.entities.concretes;
import java.util.List;
import com.example.demo.entities.abstracts.ModelDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="models")
@Entity
public class Model {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="modelYear")
	private int modelYear;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")  // ORM içerisinde ID ile maplenecek.
	@JsonIgnore
	private Brand brand;
	
	@OneToMany(mappedBy = "model")
	private List<Car> cars;
	
	@OneToOne(mappedBy = "model")
	private ModelDetails modelDetails;
}
