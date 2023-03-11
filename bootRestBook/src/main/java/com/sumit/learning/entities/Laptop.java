package com.sumit.learning.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Table(name="Student_Laptop")
public class Laptop {
	
	@Id
	private int lapTopId;
	private String modelNumber;
	private String brandName;
	
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student student;
	

}
