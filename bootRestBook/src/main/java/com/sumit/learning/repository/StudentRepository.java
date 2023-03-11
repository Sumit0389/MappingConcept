package com.sumit.learning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sumit.learning.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	

}
