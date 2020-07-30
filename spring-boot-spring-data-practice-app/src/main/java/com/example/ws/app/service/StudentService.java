package com.example.ws.app.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ws.app.model.Student;
import com.example.ws.app.repository.StudentRepository;
import com.example.ws.app.request.StudentRequest;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository repository;
	
	public StudentRequest saveStudent(StudentRequest studentDetails) {
		
		StudentRequest stu=new StudentRequest();
		BeanUtils.copyProperties(studentDetails, stu);
		
		Student student=new Student();
		BeanUtils.copyProperties(stu, student);
		
		repository.save(student);
		
		return stu;
	}
	
	public StudentRequest getStudent(String collageName) {
		
		StudentRequest stuReq=new StudentRequest();
		Student student=repository.findByCollageName(collageName);
		
		BeanUtils.copyProperties(student, stuReq);
		
		return stuReq;
	}

	public void deleteStudent(Long id) {
		
		repository.deleteById(id);
		
	}

	@Transactional
	public StudentRequest updateStudent(String collageName,String firstName) {
		
		StudentRequest stuRe=new StudentRequest();
		
		repository.updateCollege(collageName,firstName);
		//BeanUtils.copyProperties(details, stuRe);
		
		Student stu=repository.findByCollageName(collageName);
		BeanUtils.copyProperties(stu, stuRe);
		
		return stuRe;
	}

}
