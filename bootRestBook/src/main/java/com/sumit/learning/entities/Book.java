package com.sumit.learning.entities;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Books")
public class Book {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="BOOK_ID")
	private int id;
	@Column(name="BOOK_NAME")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Auther auther;

}
