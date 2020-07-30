package com.example.ws.app.controller;

import java.net.URI;

import javax.sound.midi.MidiDevice.Info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.ws.app.exceptions.InformationNotFound;
import com.example.ws.app.request.StudentRequest;
import com.example.ws.app.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	Logger logger=LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService service;
	
	
	@SuppressWarnings("unchecked")
	@PostMapping(value = "/saveRecord")
	public ResponseEntity<Object> saveStudent(@RequestBody StudentRequest studentDetails) {
		
		StudentRequest student=service.saveStudent(studentDetails);
		
		logger.info("------------------------------------Saved Student-------------------");
		logger.info(student.toString());
		
		URI location=ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(student.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping(value = "/getStudentByCollage")
	public StudentRequest getStudent(@RequestParam String collageName) {
		
		StudentRequest student=service.getStudent(collageName);
		
		if (student==null) {
			throw new InformationNotFound("The resource not found for the following request -"+collageName);
		}
		
		logger.info("Log Information for getStudent:-"+student.toString());
		
		return student;
	}
	
	@DeleteMapping(value = "/deleteRecord")
	public String deleteStudent(@RequestParam Long id) {
		
		service.deleteStudent(id);
		
		return "Record for Id : "+id+" is deleted";
	}
	
	@PutMapping(value = "/updateRecord")
	public String updateStudent(@RequestParam String collageName,String firstName) {
		
		StudentRequest details=service.updateStudent(collageName,firstName);
		logger.info("Updated record is :"+details.toString());
		
		return "Record for Id : "+details.getId()+" is Updated Successfully";
		
	}
	

}
