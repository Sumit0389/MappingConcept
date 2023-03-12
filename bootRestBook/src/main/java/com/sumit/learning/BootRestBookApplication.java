package com.sumit.learning;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.sumit.learning.entities.Address;
import com.sumit.learning.entities.Category;
import com.sumit.learning.entities.Laptop;
import com.sumit.learning.entities.Product;
import com.sumit.learning.entities.Student;
import com.sumit.learning.repository.CategoryRepo;
import com.sumit.learning.repository.ProductRepo;
import com.sumit.learning.repository.StudentRepository;

@SpringBootApplication
public class BootRestBookApplication implements CommandLineRunner {
    @Autowired
	private StudentRepository repository;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
	 
	public static void main(String[] args) {
		SpringApplication.run(BootRestBookApplication.class, args);
		System.out.println("");
		
	}
	//jhj

	@Override
	public void run(String... args) throws Exception {
		
		Student student= new Student();
		student.setAbout("I am CS Department");
		student.setName("Sumit Shrivastava");
		student.setStudentId(101);
		
		Laptop laptop= new Laptop();
		laptop.setBrandName("HP");
		laptop.setModelNumber("12344");
		laptop.setLapTopId(201);
		
		laptop.setStudent(student);
		student.setLaptop(laptop);
		
	    List<Address> list= new ArrayList<>();
	    
	    Address address= new Address();
	    address.setAdressId(101);
	    address.setCity("Bangalore");
	    address.setCountry("India");
	    address.setPostsal(560102);
	    address.setStudent(student);
	    
	    list.add(address);
	    
	    Address  address1= new Address();
	    address1.setAdressId(102);
	    address1.setCity("Datia");
	    address1.setCountry("National Highway");
	    address1.setPostsal(560103);
	    address1.setStudent(student);
	    list.add(address1);
	    
	    
	   // address.setStudent(student);
		student.setAddresses(list);
		repository.save(student);
		
		
		
		Product product1= new Product();
		product1.setProdId("101");
		product1.setProductName("Iphone");
		
		Product product2= new Product();
		product2.setProdId("102");
		product2.setProductName("samsung");
		
		Product product3= new Product();
		product3.setProdId("103");
		product3.setProductName("samsung TV");
			
		/*
		 * List<Product> elctroniproduct= new ArrayList<>();
		 * elctroniproduct.add(product); elctroniproduct.add(product2);
		 * 
		 * List<Product> mobileProducts= new ArrayList<>(); mobileProducts.add(product);
		 * mobileProducts.add(product1);
		 */
		
		
		
		Category category1= new Category();
		category1.setCatid("1001");
		category1.setTitle("Electroni");
		
		Category category2= new Category();
		category2.setCatid("1002");
		category2.setTitle("Mobile Phone");
		
		/*
		 * List<Category> categories= new ArrayList<>(); categories.add(category);
		 * categories.add(category1);
		 */
		List<Product> mobileProducts= new ArrayList<>();
		mobileProducts.add(product1);
		mobileProducts.add(product2);
		
		List<Product> electronicProducts= new ArrayList<>();
		mobileProducts.add(product1);
		mobileProducts.add(product2);
		mobileProducts.add(product3);
		
		List<Category> categories= new ArrayList<>();
		categories.add(category1);
		categories.add(category2);
		
		category1.setProductList(mobileProducts);
		category2.setProductList(electronicProducts);
	    product1.setCategories(categories);
	    
		categoryRepo.save(category1);
		categoryRepo.save(category2);
		
		//productRepo.save(product);
		
		
		
		
		
		
	}

}
