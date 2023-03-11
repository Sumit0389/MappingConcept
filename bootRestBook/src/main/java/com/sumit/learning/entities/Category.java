package com.sumit.learning.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="jpa_Category")
public class Category {
	@Id
	private String catid;
	private String title;
	
	@ManyToMany(mappedBy = "categories" ,cascade = CascadeType.ALL)
	private List<Product> productList;
}
