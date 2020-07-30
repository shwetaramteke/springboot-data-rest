package com.example.ws.app.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.ws.app.model.Student;
import com.example.ws.app.request.StudentRequest;

public interface StudentRepository extends CrudRepository<Student, Long> {
	
	Student findByCollageName(String collageName);

	StudentRequest save(StudentRequest stu);
	
	@Transactional
	@Modifying
    @Query("UPDATE Student c SET c.collageName = :collageName WHERE c.firstName = :firstName")
	Integer updateCollege(String collageName,String firstName);

}
