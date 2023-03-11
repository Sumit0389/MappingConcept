package com.sumit.learning.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="JPA_STUDENT")
public class Student {
	@Id
	private int studentId;
	private String name;
	private String about;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<Address> addresses;
	
    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
	private Laptop laptop;

}
