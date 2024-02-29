package org.employee.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class EmployeeRequest {

	@NotNull(message = "Full name cannot be null, it is mendatory")
	@NotBlank(message = "Full name cannot be blank")
	private String fullName;
	
	private String position;
	private String gender;
	private String salary;
	
	@NotNull(message = "Email id cannot be null")
	@NotBlank(message = "Email id cannot be blank")
//	@Max(value = 10,  message = "Enter mobile number without country code")
//	@Min(value = 10 , message = "Enter mobile number without country code" )
	private String phone;
	private String age;
	
	@NotNull(message = "Email id cannot be null")
	@NotBlank(message = "Email id cannot be blank")
	private String eMail;
	
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
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
}
