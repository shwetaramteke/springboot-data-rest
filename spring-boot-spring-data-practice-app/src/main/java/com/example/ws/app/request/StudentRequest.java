package com.example.ws.app.request;

public class StudentRequest {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String collageName;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCollageName() {
		return collageName;
	}

	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}

	@Override
	public String toString() {
		return "Student [ firstName=" + firstName + ", lastName=" + lastName + ", collageName="
				+ collageName + "]";
	}

}
