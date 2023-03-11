package com.sumit.learning.entities;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="jpa_adress")
public class Address {
    @Id
	private int adressId;
	private String city;
	private String country;
	private int postsal;
	@ManyToOne
	@JoinColumn(name="Student_ID")
	private Student student;
	
}
