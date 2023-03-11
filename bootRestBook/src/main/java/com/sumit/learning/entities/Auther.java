package com.sumit.learning.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="AUTHER_DATA")
public class Auther {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	@Column(name="AUTHER_FIRST_NAME")
	private String firstName;
	@Column(name="AUTHER_LAST_NAME")
	private String lastName;
	@Column(name="AUTHER_LAN")
	private String language;
	@OneToOne(mappedBy = "auther")
	@JsonBackReference
	private Book book;
	

}
