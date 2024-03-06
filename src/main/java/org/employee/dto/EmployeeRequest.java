package org.employee.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {

	@NotNull(message = "Full name cannot be null, it is mendatory")
	@NotBlank(message = "Full name cannot be blank")
	@Pattern(regexp = "[a-zA-Z]{2,50}[\\s][a-zA-Z]{2,50}")
	private String fullName;
	
	private String position;
	private String gender;
	private String salary;
	
	@NotNull(message = "Phone number cannot be null")
	@Pattern(regexp = "[789][0-9]{9}")
	private String phone;
	private String age;
	
	@NotNull(message = "Email id cannot be null")
	@NotBlank(message = "Email id cannot be blank")
	@Pattern(regexp = "a-zA-Z0-9]+[@][a-z]+[/.][a-z]{2,3}")
	private String emailId;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String geteMail() {
		return emailId;
	}
	public void seteMail(String eMail) {
		this.emailId = eMail;
	}
}
